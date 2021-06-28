package com.doan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "paypalbill")
public class PaypalBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billId")
    private Integer billId;
    @Column(name = "Amount")
    private Long Amount;
    @Column(name = "status")
    private String status;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;

    public PaypalBill() {
    }

    public PaypalBill(Integer billId, Long amount, String status, Date createAt, Date updateAt) {
        this.billId = billId;
        Amount = amount;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
