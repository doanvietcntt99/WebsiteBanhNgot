package com.doan.model;

public class dashbroadOrderDetail {
    public Integer product_Id;
    public Integer total_amount;
    public Long total_money;

    public dashbroadOrderDetail() {
    }

    public dashbroadOrderDetail(Integer product_Id, Integer total_amount, Long total_money) {
        this.product_Id = product_Id;
        this.total_amount = total_amount;
        this.total_money = total_money;
    }

    public Integer getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Integer product_Id) {
        this.product_Id = product_Id;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public Long getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Long total_money) {
        this.total_money = total_money;
    }
}
