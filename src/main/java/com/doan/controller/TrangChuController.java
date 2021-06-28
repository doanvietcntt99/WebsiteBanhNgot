package com.doan.controller;

import com.doan.model.*;
import com.doan.repository.*;
import com.doan.util.AccessAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TrangChuController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/home")
    public String rediectHome(){
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<ProductType> prodctTypeListActive =productTypeRepository.getAllProductTypeByStatus(true);
        int i = 0;
        for (ProductType productType: prodctTypeListActive){
            if(i > 3){
                break;
            }

            List<Product> listProduct = productRepository.getProductsByTypeIdVisible(productType.getProductTypeId(), true);

            model.addAttribute("listProduct"+i, listProduct);
            model.addAttribute("productType"+i, productType);
            i++;
        }

        model.addAttribute("prodctTypeListActive", prodctTypeListActive);

        return "TrangChu";
    }
    @GetMapping("/gioithieu")
    private String viewGioiThieu(Model model){
        List<ProductType> prodctTypeListActive =productTypeRepository.getAllProductTypeByStatus(true);
        model.addAttribute("prodctTypeListActive", prodctTypeListActive);
        return "gioithieu";
    }
    @GetMapping("/category")
    private String viewCakesByCategory(Model model, @RequestParam("categoryId") int categoryId){
        List<Product> productList = productRepository.getProductsByTypeIdVisible(categoryId, true);
        ProductType productType = productTypeRepository.getById(categoryId);
        List<ProductType> prodctTypeListActive =productTypeRepository.getAllProductTypeByStatus(true);
        model.addAttribute("prodctTypeListActive", prodctTypeListActive);
        model.addAttribute("productType", productType);
        model.addAttribute("productList", productList);
        return "dsSanPhamTheoCategory";

    }
    @GetMapping("/product")
    private String viewProductByProductId(Model model, @RequestParam("productId") int productId){
        List<ProductType> prodctTypeListActive =productTypeRepository.getAllProductTypeByStatus(true);
        Product product = productRepository.getById(productId);
        List<ProductImage> productImageList = productImageRepository.findProductImageByProductId(productId);
        ProductType productType = productTypeRepository.getById(product.getProductTypeId());
        Order order = new Order();
        order.setProductId(productId);

        model.addAttribute("productType", productType);
        model.addAttribute("order", order);
        model.addAttribute("productImageList", productImageList);
        model.addAttribute("product", product);
        model.addAttribute("prodctTypeListActive", prodctTypeListActive);

        return "chitietSP";
    }
    @PostMapping("/createOrder")
    private String createOrder(Model model, @ModelAttribute("order") Order order){

        Product product = productRepository.getProductById(order.getProductId());
        order.setPrice(product.getPrice());
        order.setTotalPrice(Double.parseDouble(String.valueOf(product.getPrice()*order.getSumOfProduct())));
        order.setHasBeenPay(false);
        order.setOrderDate(new Date());
        order.setCreateAt(new Date());
        order.setEmailGuest(order.getEmailGuest());
        order.setUpdateAt(new Date());
        try {
            Order orderNew = orderRepository.save(order);
            EmailSendController.SendEmail(order);
            TelegramController.callExec(
                    "Đơn hàng " + orderNew.getOrderId() + " đã được tạo!"
                            + "\n Chi tiết hóa đơn: \n + Họ tên KH: " + order.getFullNameGuest()
                            + "\n + SĐT KH: " + order.getPhoneGuest() + "\n + Địa chỉ KH: "+ order.getAddressGuest()
                            + "\n + Tên Bánh: " + product.getProductName() +"\n + Số Lượng: " + order.getSumOfProduct()
                            + "\n + Tổng tiền: " + order.getTotalPrice() + " VNĐ\n + Nội dung đơn hàng: " + order.getOrderContext() ,
                            accountRepository.getListAccountBotID());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/product?productId="+order.getProductId();
    }
    @GetMapping("/initPay")
    private String initPayment(Model model, @RequestParam("orderId") int orderId, HttpServletRequest request) throws IOException {
        Order order = orderRepository.getById(orderId);
        Double moneyConvert = AccessAPI.getUSDVND();
        double moneyPay = order.getTotalPrice()/moneyConvert;
        long money = Math.round(moneyPay * 10)/ 10;

        return null;
    }
}
