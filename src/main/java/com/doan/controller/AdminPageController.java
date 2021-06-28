package com.doan.controller;


import com.doan.model.*;
import com.doan.repository.*;
import com.doan.util.FileUploadUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @GetMapping("/admin/home")
    public String rediectHome(){
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        int totalOrderPaied = orderRepository.findOrderByHasBeenPay(true).size();
        int totalOrder = orderRepository.getAllOrder().size();
        int totalGuest = getGuest().size();
        List<Order> orderList = orderRepository.getAllOrder();
        Double totalDoanhThu = 0D;
        for(Order order :orderList ){
            totalDoanhThu += order.getTotalPrice();
        }
        List<Order> orderNotPay = orderRepository.findOrderByHasBeenPay(false);
        System.out.println(totalOrderPaied + " / " + totalOrder);
        model.addAttribute("orderNotPay", orderNotPay);
        model.addAttribute("totalDoanhThu", totalDoanhThu);
        model.addAttribute("totalOrderPaied", totalOrderPaied);
        model.addAttribute("totalOrder", totalOrder);
        model.addAttribute("totalGuest", totalGuest);
        return "admin-dashboard";
    }

    @GetMapping("/userProfile")
    public String viewUserProfile(Model model) {
        Account account = accountRepository.getById(1);
        model.addAttribute("account", account);
        return "admin-user";
    }
    @GetMapping("/cakesList")
    public String viewListCake(Model model){
        List<Product> productList = productRepository.getAllProduct();
        List<ProductType> productTypeList = productTypeRepository.getAllProductTypeByStatus(true);
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

        Product newProduct = new Product();
        model.addAttribute("productList", productViewList);
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("productTypeList", productTypeList);
        return "admin-dsSanPham";
    }

    @GetMapping("/viewListCategory")
    public String viewListCategory(Model model){
        List<ProductType> productTypeList = productTypeRepository.getAllProductType();
        ProductType productType = new ProductType();
        model.addAttribute("productTypeList", productTypeList);
        model.addAttribute("productType", productType);
        return "admin-dsCategory";
    }
    @PostMapping("/addNewProductType")
    public String addNewProductType(Model model, @ModelAttribute("productType") ProductType productType){
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
    @GetMapping("/switchVisibleProductType")
    public String switchVisibleProductType(Model model, @RequestParam("productTypeId") int productTypeId){
        ProductType productType = productTypeRepository.getById(productTypeId);
        if(productType.getStatus()){
            productType.setStatus(false);
        } else {
            productType.setStatus(true);
        }
        try {
            productTypeRepository.save(productType);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "redirect:/viewListCategory";
    }
    @GetMapping("/deleteProductType")
    public String deleteProductType(Model model, @RequestParam("productTypeId") int productTypeId){
        ProductType productType = productTypeRepository.getById(productTypeId);

        try {
            productTypeRepository.delete(productType);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/viewListCategory";
    }

    @PostMapping("/updateProductType")
    public String updateProductType(Model model, @RequestParam("productTypeId") int productTypeId, @ModelAttribute("productType") ProductType productType){
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
    public String updateUserProfile(Model model, @ModelAttribute("account") Account account){
        Account oldAccount = accountRepository.getById(1);
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
    public String switchVisible(Model model, @RequestParam("productId") int productId){
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
    public String deleteProduct (Model model, @RequestParam("productId") int productId){
        Product product = productRepository.getProductById(productId);
        productRepository.delete(product);
        return "redirect:/cakesList";
    }
    @PostMapping("/addNewProduct")
    public String addNewProduct (Model model, @ModelAttribute("newProduct") Product p, HttpServletRequest request){

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
            productRepository.save(addNew);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/cakesList";

    }
    @GetMapping("/editProduct")
    public String viewEditProductPage(Model model, @RequestParam("productId") int productId){

        Product product = productRepository.getProductById(productId);
        List<ProductImage> productImageList = productImageRepository.findProductImageByProductId(product.getProductId());
        model.addAttribute("product", product);
        model.addAttribute("productImageList", productImageList);
        return "admin-detailSanPham";
    }

@PostMapping("/user/saveAvatar")
public String saveUserAvatar(@ModelAttribute("account") Account a,
                             @RequestParam("image") MultipartFile multipartFile) throws IOException, InterruptedException {
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
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException, InterruptedException {

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
                           @RequestParam("image") MultipartFile multipartFile) throws IOException, InterruptedException {

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
    public String updateProduct(Mode model, @ModelAttribute("product") Product product){
        Product oldProduct = productRepository.getProductById(product.getProductId());
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDetail(product.getDetail());
        oldProduct.setAmount(product.getAmount());
        oldProduct.setPrice(product.getPrice());
        try {
            productRepository.save(oldProduct);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/editProduct?productId=" + oldProduct.getProductId();
    }
    @GetMapping("/switchHasbeenPay")
    public String switchHasbeenPay(Model model, @RequestParam("orderId") int orderId){
        Order order = orderRepository.getById(orderId);
        if(order.isHasBeenPay()){
            order.setHasBeenPay(false);
            TelegramController.callExec
                    ("Đơn hàng " + orderId + " được chuyển từ đã thanh toán thành chưa thanh toán trên hệ thống quản trị!",
                            accountRepository.getListAccountBotID());
        } else {
            order.setHasBeenPay(true);
            TelegramController.callExec
                    ("Đơn hàng " + orderId + " được chuyển từ chưa thanh toán thành đã thanh toán trên hệ thống quản trị!",
                            accountRepository.getListAccountBotID());
        }
        order.setUpdateAt(new Date());
        orderRepository.save(order);
        return "redirect:/viewListOrder";
    }

    @GetMapping("/switchVisibleProductImage")
    public String switchVisibleProductImage(Model model, @RequestParam("productImageId") int productImageId){
        ProductImage product = productImageRepository.getById(productImageId);
        if(product.getStatus()){
            product.setStatus(false);

        } else {
            product.setStatus(true);
        }
        product.setUpdateAt(new Date());
        productImageRepository.save(product);
        return "redirect:/editProduct?productId=" + product.getProductId();
    }

    @GetMapping("/deleteProductImage")
    public String deleteProductImage (Model model, @RequestParam("productImageId") int productImageId){
        ProductImage product = productImageRepository.getById(productImageId);
        int idProduct = product.getProductId();
        productImageRepository.delete(product);
        return "redirect:/editProduct?productId=" + idProduct;
    }

    @GetMapping("/viewListOrder")
    public String viewListOrder (Model model) {
        List<Order> orderList = orderRepository.getAllOrderOrderByCreateDateDESC();
        model.addAttribute("orderList", orderList);
        return "admin-dsOrder";
    }
    @GetMapping("/deleteOrder")
    public String deleteOrder (Model model, @RequestParam("orderId") int orderId){
        Order order = orderRepository.getById(orderId);
        try {
            orderRepository.delete(order);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/viewListOrder";
    }
    @GetMapping("/viewListGuest")
    public String viewListGuest(Model model){

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

}



