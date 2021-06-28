package com.doan.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ProductImage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImageId")
    private Integer productImageId;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "nameImage")
    private String nameImage;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;

    public ProductImage() {
    }

    public ProductImage(Integer productImageId, Integer productId, String nameImage, Boolean status, Date createAt, Date updateAt) {
        this.productImageId = productImageId;
        this.productId = productId;
        this.nameImage = nameImage;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
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
