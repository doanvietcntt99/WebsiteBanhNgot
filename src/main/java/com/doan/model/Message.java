package com.doan.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMessage")
    private Integer idMessage;
    @Column(name = "nameUser")
    private String nameUser;
    @Column(name = "Message", length = 500)
    private String Message;
    @Column(name="status")
    private String status;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;

    public Message() {
    }

    public Message(Integer idMessage, String nameUser, String message, String status, Date createAt, Date updateAt) {
        this.idMessage = idMessage;
        this.nameUser = nameUser;
        Message = message;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
