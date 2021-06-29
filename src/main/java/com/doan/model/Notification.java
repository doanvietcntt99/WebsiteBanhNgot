package com.doan.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotification")
    private Integer idNotification;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;
    @Column(name = "closedByUserId")
    private Integer closedByUserId;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private Boolean status;

    public Notification() {
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
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

    public Integer getClosedByUserId() {
        return closedByUserId;
    }

    public void setClosedByUserId(Integer closedByUserId) {
        this.closedByUserId = closedByUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
