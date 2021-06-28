package com.doan.model;

import javax.persistence.Column;

public class View_Guest {
    private String fullNameGuest;
    private String phoneGuest;
    private String addressGuest;
    private Double totalPrice;
    private int TotalProduct;

    public View_Guest() {
    }

    public int getTotalProduct() {
        return TotalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        TotalProduct = totalProduct;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
