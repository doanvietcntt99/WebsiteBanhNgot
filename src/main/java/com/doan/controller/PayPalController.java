package com.doan.controller;


import com.doan.config.PaypalPaymentIntent;
import com.doan.config.PaypalPaymentMethod;
import com.doan.model.Notification;
import com.doan.model.Order;
import com.doan.repository.AccountRepository;
import com.doan.repository.NotificaionRepository;
import com.doan.repository.OrderRepository;
import com.doan.service.PaypalService;
import com.doan.util.PayPalUtil;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PayPalController {

    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";
    public static final String MONEY_TYPE = "USD";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private NotificaionRepository notificaionRepository;

//    @GetMapping("/initPay")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/pay")
    public String pay(HttpServletRequest request,@RequestParam("price") double price, @RequestParam("orderId") int orderId){
        String cancelUrl = PayPalUtil.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
        String successUrl = PayPalUtil.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS+"?orderId=" + orderId;
        try {
            Payment payment = paypalService.createPayment(
                    price,
                    MONEY_TYPE,
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay(){
        return "cancel";
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, @RequestParam("orderId") int orderId){

        Order order = orderRepository.getById(orderId);
        order.setHasBeenPay(true);
        order.setUpdateAt(new Date());
        orderRepository.save(order);
        String message = "Đơn hàng " + order.getOrderId() + " đã được thanh toán trực tuyến qua Paypal!";

        TelegramController.callExec(message, accountRepository.getListAccountBotID());

        EmailSendController.SendEmailPaypalSuccessFul(order);
        Notification notification = new Notification();
        notification.setStatus(true);
        notification.setCreateAt(new Date());
        notification.setUpdateAt(new Date());
        notification.setContent(message);
        notificaionRepository.save(notification);

        return "ThanhToanThanhCong";
    }

}
