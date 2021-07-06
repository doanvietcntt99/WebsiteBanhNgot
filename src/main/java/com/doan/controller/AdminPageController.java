package com.doan.controller;


import com.doan.model.*;
import com.doan.repository.*;
import com.doan.util.FileUploadUtil;
import com.doan.util.MD5Util;
import org.dom4j.rule.Mode;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class AdminPageController {
    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private NotificaionRepository notificaionRepository;


    @GetMapping("/admin/home")
    public String rediectHome(){
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        int totalOrderPaied = orderRepository.findOrderByHasBeenPay(true).size();
        int totalOrder = orderRepository.getAllOrder().size();
        int totalGuest = getGuest().size();
        List<Order> orderList = orderRepository.getAllOrder();
        Double totalDoanhThu = 0D;
        for(Order order :orderList ){
            totalDoanhThu += order.getTotalPrice();
        }
        List<Order> orderNotPay = orderRepository.findOrderByHasBeenPay(false);
        model.addAttribute("orderNotPay", orderNotPay);
        model.addAttribute("totalDoanhThu", totalDoanhThu);
        model.addAttribute("totalOrderPaied", totalOrderPaied);
        model.addAttribute("totalOrder", totalOrder);
        model.addAttribute("totalGuest", totalGuest);
        model.addAttribute("notificationListActive", notificationListActive);

        return "admin-dashboard";
    }
    @GetMapping("/SeenNotification")
    public String SeenNotification(Model model, @ModelAttribute("idNotification") int idNotification, HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        } else {
            int idAccountSeen = Integer.parseInt(session.getAttribute("idAccount").toString());
            Notification notification = notificaionRepository.getById(idNotification);
            notification.setUpdateAt(new Date());
            notification.setStatus(false);
            notification.setClosedByUserId(idAccountSeen);
            notificaionRepository.save(notification);
            return "redirect:/admin";
        }

    }

    @GetMapping("/userProfile")
    public String viewUserProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);

        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));
        UpdatePassword updatePassword = new UpdatePassword();
        model.addAttribute("account", account);
        model.addAttribute("updatePassword", updatePassword);
        return "admin-user";
    }
    @PostMapping("/user/updatePassword")
    public String updatePassword(Model model, @ModelAttribute("updatePassword") UpdatePassword updatePassword, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        try {
            Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

//            System.out.println(updatePassword.getPassword() + "....." + updatePassword.getRePassword());
            String passwordOldEncrpyt = MD5Util.md5(updatePassword.getOldPassword());
            if(updatePassword.getPassword().equalsIgnoreCase(updatePassword.getRePassword())){
                if(account.getPassword().equalsIgnoreCase(passwordOldEncrpyt)){
                    account.setPassword(MD5Util.md5(updatePassword.getPassword()));
                    account.setUpdateAt(new Date());
                    accountRepository.save(account);

                }
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/userProfile";

    }



    @PostMapping("/addNewProductType")
    public String addNewProductType(Model model, @ModelAttribute("productType") ProductType productType, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        ProductType productType1 = new ProductType();
        productType1.setProductTypeName(productType.getProductTypeName());
        productType1.setCreateAt(new Date());
        productType1.setUpdateAt(new Date());
        productType1.setStatus(true);
        try {
            productTypeRepository.save(productType1);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/viewListCategory";
    }

    @PostMapping("/addNewAccount")
    public String addNewAccount(Model model, @ModelAttribute("newAccount") Account newAccount, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        newAccount.setCreateAt(new Date());
        newAccount.setStatus(true);
        newAccount.setAdmin(true);
        newAccount.setUpdateAt(new Date());
        newAccount.setAvatar("no-image-product.jpg");
        newAccount.setPassword(MD5Util.md5("admin123"));
        try {
            accountRepository.save(newAccount);
            String message = "Tài khoản : " + newAccount.getFullname() + " đã được tạo thành công bởi quản trị viên : " + account.getFullname();
            createNotification(message);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        return "redirect:/viewListAdmin";
    }

    @GetMapping("/switchVisibleProductType")
    public String switchVisibleProductType(Model model, @RequestParam("productTypeId") int productTypeId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        try {
            ProductType productType = productTypeRepository.getById(productTypeId);
            if(productType.getStatus()){
                productType.setStatus(false);
            } else {
                productType.setStatus(true);
            }
            productTypeRepository.save(productType);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "redirect:/viewListCategory";
    }
    @GetMapping("/deleteProductType")
    public String deleteProductType(Model model, @RequestParam("productTypeId") int productTypeId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }


        ProductType productType = productTypeRepository.getById(productTypeId);

        try {
            productTypeRepository.delete(productType);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/viewListCategory";
    }

    @PostMapping("/updateProductType")
    public String updateProductType(Model model, @RequestParam("productTypeId") int productTypeId, @ModelAttribute("productType") ProductType productType, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        ProductType productType1 = productTypeRepository.getById(productTypeId);
        productType1.setProductTypeName(productType.getProductTypeName());
        productType1.setUpdateAt(new Date());
        try {
            productTypeRepository.save(productType1);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/viewListCategory";
    }
    @PostMapping("/updateProfile")
    public String updateUserProfile(Model model, @ModelAttribute("account") Account account, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        Account oldAccount = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));
        oldAccount.setEmail(account.getEmail());
        oldAccount.setFullname(account.getFullname());
        oldAccount.setPhone(account.getPhone());
        oldAccount.setAddress(account.getAddress());
        oldAccount.setTelegramUsername(account.getTelegramUsername());
        oldAccount.setStatus(account.isStatus());
        accountRepository.save(oldAccount);
        return "redirect:/userProfile";
    }
    @GetMapping("/switchVisible")
    public String switchVisible(Model model, @RequestParam("productId") int productId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        Product product = productRepository.getProductById(productId);
        if(product.isVisible()){
            product.setVisible(false);
        } else {
            product.setVisible(true);
        }
        productRepository.save(product);
        return "redirect:/cakesList";
    }
    @GetMapping("/deleteProduct")
    public String deleteProduct (Model model, @RequestParam("productId") int productId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        Product product = productRepository.getProductById(productId);
        productRepository.delete(product);
        return "redirect:/cakesList";
    }
    @PostMapping("/addNewProduct")
    public String addNewProduct (Model model, @ModelAttribute("newProduct") Product p, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));


        Product addNew = new Product();
        addNew.setProductName(p.getProductName());
        addNew.setProductTypeId(p.getProductTypeId());
        addNew.setPrice(p.getPrice());
        addNew.setDetail(p.getDetail());
        addNew.setStatus(true);
        addNew.setVisible(true);
        addNew.setProductImage("no-image-product.jpg");
        addNew.setCreateAt(new Date());
        addNew.setUpdateAt(new Date());
        try {
            Product add = productRepository.save(addNew);
            String message = "Sản phẩm mới được khởi tạo thành công bởi quản trị viên: " + account.getFullname()
                    + "\n ID: " + add.getProductId()
                    + "\n Tên SP: " + add.getProductName()
                    + "\n Mã Loại SP: " + add.getProductTypeId()
                    + "\n Mô tả: " + add.getDetail()
                    + "\n Đơn Giá: " + add.getPrice();
            createNotification(message);

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/cakesList";

    }
    @GetMapping("/editProduct")
    public String viewEditProductPage(Model model, @RequestParam("productId") int productId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);


        List<ProductType> productTypeList = productTypeRepository.getAllProductTypeByStatus(true);


        Product product = productRepository.getProductById(productId);
        List<ProductImage> productImageList = productImageRepository.findProductImageByProductId(product.getProductId());
        model.addAttribute("product", product);
        model.addAttribute("productTypeList", productTypeList);
        model.addAttribute("productImageList", productImageList);
        return "admin-detailSanPham";
    }

@PostMapping("/user/saveAvatar")
public String saveUserAvatar(@ModelAttribute("account") Account a,
                             @RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) throws IOException, InterruptedException {

    HttpSession session = request.getSession();
    if(session.getAttribute("idAccount")== null){
        return "redirect:/login";
    }

    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

    Account account = accountRepository.getById(a.getIdAccount());
    account.setAvatar(fileName);
    account.setUpdateAt(new Date());

    accountRepository.save(account);

    String uploadDir = "src/main/resources/static/img/";

    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    Thread.sleep(2000);
    return "redirect:/userProfile";
}
    @PostMapping("/product/saveAvatar")
    public String saveProductAvatar(@ModelAttribute("product") Product p,
                                 @RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) throws IOException, InterruptedException {

        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Product product = productRepository.getProductById(p.getProductId());
        product.setProductImage(fileName);
        product.setUpdateAt(new Date());

        productRepository.save(product);

        String uploadDir = "src/main/resources/static/img/";

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        Thread.sleep(2000);
        return "redirect:/editProduct?productId=" + product.getProductId();
    }

    @PostMapping("/product/productImages")
    public String saveProductImages(@ModelAttribute("product") Product p,
                           @RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) throws IOException, InterruptedException {

        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        ProductImage productImage = new ProductImage();
        productImage.setCreateAt(new Date());
        productImage.setUpdateAt(new Date());
        productImage.setNameImage(fileName);
        productImage.setProductId(p.getProductId());
        productImage.setStatus(true);

        productImageRepository.save(productImage);

        String uploadDir = "src/main/resources/static/img/";

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        Thread.sleep(2000);
        return "redirect:/editProduct?productId=" + p.getProductId();
    }


    @PostMapping("/updateProduct")
    public String updateProduct(Mode model, @ModelAttribute("product") Product product, HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        Product oldProduct = productRepository.getProductById(product.getProductId());
        String oldNameProduct = oldProduct.getProductName();
        oldProduct.setProductTypeId(product.getProductTypeId());
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDetail(product.getDetail());
        oldProduct.setAmount(product.getAmount());
        oldProduct.setPrice(product.getPrice());
        try {
            productRepository.save(oldProduct);
            String message = "Sản phẩm " + oldProduct.getProductId() + " được cập nhật mới bởi Quản trị viên: "+ account.getFullname();
            TelegramController.callExec
                    (message, accountRepository.getListAccountBotID());
            createNotification(message);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/editProduct?productId=" + oldProduct.getProductId();
    }
    @GetMapping("/switchHasbeenPay")
    public String switchHasbeenPay(Model model, @RequestParam("orderId") int orderId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        Order order = orderRepository.getById(orderId);
        if(order.isHasBeenPay()){
            order.setHasBeenPay(false);
            String message = "Đơn hàng " + orderId + " được chuyển từ đã thanh toán thành chưa thanh toán trên hệ thống quản trị bởi quản trị viên: " + account.getFullname();
            TelegramController.callExec
                    (message, accountRepository.getListAccountBotID());
            createNotification(message);
        } else {
            order.setHasBeenPay(true);
            String message = "Đơn hàng " + orderId + " được chuyển từ chưa thanh toán thành đã thanh toán trên hệ thống quản trị bởi quản trị viên: " + account.getFullname();
            TelegramController.callExec
                    (message,
                            accountRepository.getListAccountBotID());
            createNotification(message);
        }
        order.setUpdateAt(new Date());
        orderRepository.save(order);
        return "redirect:/viewListOrder";
    }
    @GetMapping("/deleteAdminAccount")
    public String deleteAdminAccount(Model model, @RequestParam("idAccount") int idAccount,  HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        Account accountDelete = accountRepository.getById(idAccount);
        if (accountDelete.getIdAccount() == account.getIdAccount()){
            return "redirect:/viewListOrder";
        }
        accountRepository.delete(accountDelete);
        String message = "Tài khoản quản trị viên : " + accountDelete.getFullname() + " đã bị xóa bỏ trên hệ thống bởi Quản trị viên : " + account.getFullname();
        createNotification(message);
        return "redirect:/viewListAdmin";
    }

    @GetMapping("/disableAdminAccount")
    public String disableAdminAccount(Model model, @RequestParam("idAccount") int idAccount,  HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        Account accountSwitch = accountRepository.getById(idAccount);
        if (accountSwitch.getIdAccount() == account.getIdAccount()){
            return "redirect:/viewListOrder";
        }
        if(accountSwitch.isStatus()){
            accountSwitch.setStatus(false);
            accountSwitch.setUpdateAt(new Date());
            accountRepository.save(accountSwitch);
            String message = "Tài khoản quản trị viên : " + accountSwitch.getFullname() + " đã bị vô hiệu hóa bởi Quản trị viên : " + account.getFullname();
            createNotification(message);
        } else {
            accountSwitch.setStatus(true);
            accountSwitch.setUpdateAt(new Date());
            accountRepository.save(accountSwitch);
            String message = "Tài khoản quản trị viên : " + accountSwitch.getFullname() + " đã kích hoạt trên hệ thống bởi Quản trị viên : " + account.getFullname();
            createNotification(message);
        }
        return "redirect:/viewListAdmin";
    }

    @GetMapping("/switchVisibleProductImage")
    public String switchVisibleProductImage(Model model, @RequestParam("productImageId") int productImageId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        ProductImage product = productImageRepository.getById(productImageId);
        if(product.getStatus()){
            product.setStatus(false);

        } else {
            product.setStatus(true);
        }
        product.setUpdateAt(new Date());
        productImageRepository.save(product);
        createNotification("Trạng Thái Ảnh " + product.getProductImageId() + " thuộc sản phẩm " + product.getProductId()+" đã được cập nhật bởi Quản Trị Viên: " + account.getFullname());
        return "redirect:/editProduct?productId=" + product.getProductId();
    }

    @GetMapping("/deleteProductImage")
    public String deleteProductImage (Model model, @RequestParam("productImageId") int productImageId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        ProductImage product = productImageRepository.getById(productImageId);
        int idProduct = product.getProductId();
        productImageRepository.delete(product);
        createNotification("Hình Ảnh " + product.getProductImageId() + " thuộc sản phẩm " + product.getProductId()+" đã được xóa bởi Quản Trị Viên: " + account.getFullname());
        return "redirect:/editProduct?productId=" + idProduct;
    }

    @GetMapping("/cakesList")
    public String viewListCake(Model model, HttpServletRequest request, RedirectAttributes redirect){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        request.getSession().setAttribute("viewCakesList", null);

        if(model.asMap().get("success") != null)
            redirect.addFlashAttribute("success",model.asMap().get("success").toString());

        return "redirect:/cakesList/page/1";
    }
    @GetMapping("/cakesList/page/{pageNumber}")
    public String cakesListPage(HttpServletRequest request,
                                       @PathVariable int pageNumber, Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);

        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("viewCakesList");
        int pagesize = 5;
        ///
        List<Product> productList = productRepository.getAllProduct();
        List<ProductType> productTypeList = productTypeRepository.getAllProductTypeByStatus(true);
        model.addAttribute("productTypeList", productTypeList);
        List<View_Product> productViewList = new ArrayList<View_Product>();
        for(Product product: productList){
            View_Product view_product = new View_Product();
            view_product.setProductId(product.getProductId());
            view_product.setProductName(product.getProductName());
            ProductType result = new ProductType();
            String productTypeName = null;
            try {
                result = productTypeRepository.getById(product.getProductTypeId());
                productTypeName = result.getProductTypeName();
            } catch (Exception ex){
            }

            view_product.setProductTypeName(productTypeName);
            view_product.setDetail(product.getDetail());
            view_product.setPrice(product.getPrice());
            view_product.setVisible(product.isVisible());
            productViewList.add(view_product);
        }
        ///
        if (pages == null) {
            pages = new PagedListHolder<>(productViewList);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("viewCakesList", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - productViewList.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/cakesList/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("cakeList", pages);

        return "admin-dsSanPham";
    }

    @GetMapping("/viewListCategory")
    public String viewListCategory(Model model, HttpServletRequest request, RedirectAttributes redirect){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        request.getSession().setAttribute("viewListCategory", null);


        if(model.asMap().get("success") != null)
            redirect.addFlashAttribute("success",model.asMap().get("success").toString());

        return "redirect:/viewListCategory/page/1";
    }
    @GetMapping("/viewListCategory/page/{pageNumber}")
    public String viewListCategoryPage(HttpServletRequest request,
                                    @PathVariable int pageNumber, Model model) {
        ProductType productType = new ProductType();
        model.addAttribute("productType", productType);
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);

        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("viewListCategory");
        int pagesize = 5;
        List<ProductType> productTypeList = productTypeRepository.getAllProductType();
        if (pages == null) {
            pages = new PagedListHolder<>(productTypeList);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("viewListCategory", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - productTypeList.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/viewListCategory/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("categoryList", pages);

        return "admin-dsCategory";
    }

    @GetMapping("/viewListAdmin")
    public String viewListAdmin (Model model, HttpServletRequest request, RedirectAttributes redirect){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        request.getSession().setAttribute("viewListAdmin", null);

        if(model.asMap().get("success") != null)
            redirect.addFlashAttribute("success",model.asMap().get("success").toString());

        return "redirect:/viewListAdmin/page/1";
    }
    @GetMapping("/viewListAdmin/page/{pageNumber}")
    public String viewListAdminPage(HttpServletRequest request,
                                    @PathVariable int pageNumber, Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = new Account();
        model.addAttribute("newAccount", account);
        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);

        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("viewOrderList");
        int pagesize = 3;
        List<Account> list = accountRepository.getAllAccount();
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("viewListAdmin", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/viewListAdmin/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("adminList", pages);

        return "admin-dsQTV";
    }


    @GetMapping("/viewListOrder")
    public String viewListOrder (Model model, HttpServletRequest request
            , RedirectAttributes redirect) {

        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

//        List<Order> orderList = orderRepository.getAllOrderOrderByCreateDateDESC();
//        model.addAttribute("orderList", orderList);
        request.getSession().setAttribute("viewOrderList", null);

        if(model.asMap().get("success") != null)
            redirect.addFlashAttribute("success",model.asMap().get("success").toString());

        return "redirect:/viewListOrder/page/1";
    }

    @GetMapping("/viewListOrder/page/{pageNumber}")
    public String viewListOrderPage(HttpServletRequest request,
                                   @PathVariable int pageNumber, Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }

        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("viewOrderList");
        int pagesize = 5;
        List<Order> list = orderRepository.getAllOrderOrderByCreateDateDESC();
        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);

        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("viewOrderList", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/viewListOrder/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("orderList", pages);

        return "admin-dsOrder";
    }


    @GetMapping("/deleteOrder")
    public String deleteOrder (Model model, @RequestParam("orderId") int orderId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        Account account = accountRepository.getById(Integer.parseInt(session.getAttribute("idAccount").toString()));

        Order order = orderRepository.getById(orderId);
        try {
            orderRepository.delete(order);
            createNotification("Đơn hàng " + order.getOrderId() + " đã được xóa bởi Quản Trị Viên: " + account.getFullname());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/viewListOrder";
    }
    @GetMapping("/viewListGuest")
    public String viewListGuest(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")== null){
            return "redirect:/login";
        }
        List<Notification> notificationListActive = notificaionRepository.getListActiveNotification();
        model.addAttribute("sizeListNotification", notificationListActive.size());
        model.addAttribute("notificationListActive", notificationListActive);
        List<View_Guest> orderListTotal = getGuest();
        model.addAttribute("orderListTotal", orderListTotal);
        return "admin-dsGuest";
    }

    private List<View_Guest> getGuest(){

        List<View_Guest> orderListTotal = new ArrayList<View_Guest>();
        List<String> orderList = orderRepository.getDistinctGuest();
        for (String order : orderList){
            List<Order> orderListBySDT = orderRepository.findOrderByPhoneGuest(order);
            int TotalProduct = 0;
            Double TotalPrice = 0D;
            for(Order order1 : orderListBySDT) {
                TotalProduct += order1.getSumOfProduct();
                TotalPrice += order1.getTotalPrice();
            }
            View_Guest view_guest = new View_Guest();
            view_guest.setAddressGuest(orderListBySDT.get(0).getAddressGuest());
            view_guest.setFullNameGuest(orderListBySDT.get(0).getFullNameGuest());
            view_guest.setPhoneGuest(orderListBySDT.get(0).getPhoneGuest());
            view_guest.setTotalProduct(TotalProduct);
            view_guest.setTotalPrice(TotalPrice);
            orderListTotal.add(view_guest);
        }
        return orderListTotal;
    }
    private Notification createNotification(String content){
        Notification notification = new Notification();
        notification.setStatus(true);
        notification.setCreateAt(new Date());
        notification.setUpdateAt(new Date());
        notification.setContent(content);
        return notificaionRepository.save(notification);
    }

}



