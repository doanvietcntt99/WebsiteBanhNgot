package com.doan.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Account")
public class Account {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAccount")
    private Integer idAccount;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
    @Column(name = "BCryptPassword")
    private String BCryptPassword;
    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "isAdmin")
    private Boolean isAdmin;
    @Column(name = "telegramUsername")
    private String telegramUsername;
    @Column(name = "botId")
    private Long botId;
    @Column(name = "status")
    private boolean status;
    @Column(name = "phone")
    private String phone;
    @Column(name = "createAt")
    private Date createAt;
    @Column(name = "updateAt")
    private Date updateAt;
    @Column(name = "address")
    private String address;
    @Column(name = "avatar")
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Account() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account(Integer idAccount, String username, String password, String BCryptPassword, String fullname, String email, Boolean isAdmin, String telegramUsername, Long botId, boolean status, String phone, Date createAt, Date updateAt, String address) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.BCryptPassword = BCryptPassword;
        this.fullname = fullname;
        this.email = email;
        this.isAdmin = isAdmin;
        this.telegramUsername = telegramUsername;
        this.botId = botId;
        this.status = status;
        this.phone = phone;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.address = address;
    }

    public String getBCryptPassword() {
        return BCryptPassword;
    }

    public void setBCryptPassword(String BCryptPassword) {
        this.BCryptPassword = BCryptPassword;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getTelegramUsername() {
        return telegramUsername;
    }

    public void setTelegramUsername(String telegramUsername) {
        this.telegramUsername = telegramUsername;
    }

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
