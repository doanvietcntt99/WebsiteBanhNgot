package com.doan.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;
    @Column(name = "fullNameGuest")
    private String fullNameGuest;
    @Column(name = "phoneGuest")
    private String phoneGuest;
    @Column(name = "addressGuest")
    private String addressGuest;
    @Column(name = "sumOfProduct")
    private Integer sumOfProduct;
    @Column(name = "orderContext")
    private String orderContext;
    @Column(name = "orderDate")
    private Date orderDate;
    @Column(name = "hasBeenPay")
    private boolean hasBeenPay;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;
    @Column(name="TotalPrice")
    private Double totalPrice;
    @Column(name="productId")
    private Integer productId;
    @Column(name = "price")
    private Long price;
    @Column(name = "emailGuest")
    private String emailGuest;

    public String getEmailGuest() {
        return emailGuest;
    }

    public void setEmailGuest(String emailGuest) {
        this.emailGuest = emailGuest;
    }

    public Order() {
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(Integer orderId, String fullNameGuest, String phoneGuest, String addressGuest, Integer sumOfProduct, String orderContext, Date orderDate, boolean hasBeenPay, Date createAt, Date updateAt, Double totalPrice, Integer productId, Long price) {
        this.orderId = orderId;
        this.fullNameGuest = fullNameGuest;
        this.phoneGuest = phoneGuest;
        this.addressGuest = addressGuest;
        this.sumOfProduct = sumOfProduct;
        this.orderContext = orderContext;
        this.orderDate = orderDate;
        this.hasBeenPay = hasBeenPay;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.totalPrice = totalPrice;
        this.productId = productId;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderContext(String orderContext) {
        this.orderContext = orderContext;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getFullNameGuest() {
        return fullNameGuest;
    }

    public void setFullNameGuest(String fullNameGuest) {
        this.fullNameGuest = fullNameGuest;
    }

    public String getPhoneGuest() {
        return phoneGuest;
    }

    public void setPhoneGuest(String phoneGuest) {
        this.phoneGuest = phoneGuest;
    }

    public String getAddressGuest() {
        return addressGuest;
    }

    public void setAddressGuest(String addressGuest) {
        this.addressGuest = addressGuest;
    }

    public Integer getSumOfProduct() {
        return sumOfProduct;
    }

    public void setSumOfProduct(Integer sumOfProduct) {
        this.sumOfProduct = sumOfProduct;
    }



    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderContext() {
        return orderContext;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isHasBeenPay() {
        return hasBeenPay;
    }

    public void setHasBeenPay(boolean hasBeenPay) {
        this.hasBeenPay = hasBeenPay;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
