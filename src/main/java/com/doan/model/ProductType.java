package com.doan.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ProductType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productTypeId")
    private Integer productTypeId;
    @Basic(optional = false)
    @Column(name = "productTypeName")
    private String productTypeName;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;
    public ProductType() {
    }

    public ProductType(Integer productTypeId, String productTypeName, Boolean status, Date createAt, Date updateAt) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
