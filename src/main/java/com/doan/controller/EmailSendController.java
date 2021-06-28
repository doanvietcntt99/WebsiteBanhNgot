package com.doan.controller;


import com.doan.model.Order;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSendController {

    private static final String Email_Sender_Address = "doanvietcntt99@gmail.com";
    private static final String Email_Sender_Password = "jqpohuppcedarhrv";
//    private static final String Email_Receive_Address = "boykutenolove2199@gmail.com";


    public static void SendEmail(Order order) {

        String Email_Receive_Address = order.getEmailGuest();
        final String username = Email_Sender_Address;
        final String password = Email_Sender_Password;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Email_Sender_Address));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(Email_Receive_Address)
            );
            message.setSubject("Thực hiện đặt hàng thành công");
            message.setText("Dear Khách Hàng " + order.getFullNameGuest()
                    + "\n\n Bạn đã đặt hàng thành công trên Website của cửa hàng!" + "\n\n Chi tiết đơn hàng : \n " +
                    "+ Mã đơn hàng : " + order.getOrderId() + "\n" +
                    "+ Người đặt hàng: " + order.getFullNameGuest() + "\n" +
                    "+ Số Điện Thoại: " + order.getPhoneGuest() + "\n" +
                    "+ Email: " + order.getEmailGuest() + "\n" +
                    "+ Số lượng Bánh: " + order.getSumOfProduct() + "\n" +
                    "+ Thành tiền: " + order.getTotalPrice() + "\n\n" + " " +
                    "Quý khách vui lòng truy cập vào đường dẫn sau để thực hiện thanh toán qua Paypal!"
                    + "Link : http://localhost:8181/initPay?orderId="+ order.getOrderId()

            );

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}


