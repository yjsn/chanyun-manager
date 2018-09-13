package com.chanyun.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String userAccount;

    private String userPassword;

    private String userPhone;

    private String webchatId;

    private Integer meritsAccount;

    private Integer meritsSelfAccount;

    private Date registTime;

    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getWebchatId() {
        return webchatId;
    }

    public void setWebchatId(String webchatId) {
        this.webchatId = webchatId == null ? null : webchatId.trim();
    }

    public Integer getMeritsAccount() {
        return meritsAccount;
    }

    public void setMeritsAccount(Integer meritsAccount) {
        this.meritsAccount = meritsAccount;
    }

    public Integer getMeritsSelfAccount() {
        return meritsSelfAccount;
    }

    public void setMeritsSelfAccount(Integer meritsSelfAccount) {
        this.meritsSelfAccount = meritsSelfAccount;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}