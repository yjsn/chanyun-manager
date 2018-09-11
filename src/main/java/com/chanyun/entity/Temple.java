package com.chanyun.entity;

import java.util.Date;

public class Temple {
    private Integer id;

    private String templeNumber;

    private String templeName;

    private String templeProvince;

    private String templeCity;

    private String templeCounty;

    private String templeAddress;

    private Integer status;

    private String templeContactName;

    private String templeContactTel;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempleNumber() {
        return templeNumber;
    }

    public void setTempleNumber(String templeNumber) {
        this.templeNumber = templeNumber == null ? null : templeNumber.trim();
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName == null ? null : templeName.trim();
    }

    public String getTempleProvince() {
        return templeProvince;
    }

    public void setTempleProvince(String templeProvince) {
        this.templeProvince = templeProvince == null ? null : templeProvince.trim();
    }

    public String getTempleCity() {
        return templeCity;
    }

    public void setTempleCity(String templeCity) {
        this.templeCity = templeCity == null ? null : templeCity.trim();
    }

    public String getTempleCounty() {
        return templeCounty;
    }

    public void setTempleCounty(String templeCounty) {
        this.templeCounty = templeCounty == null ? null : templeCounty.trim();
    }

    public String getTempleAddress() {
        return templeAddress;
    }

    public void setTempleAddress(String templeAddress) {
        this.templeAddress = templeAddress == null ? null : templeAddress.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTempleContactName() {
        return templeContactName;
    }

    public void setTempleContactName(String templeContactName) {
        this.templeContactName = templeContactName == null ? null : templeContactName.trim();
    }

    public String getTempleContactTel() {
        return templeContactTel;
    }

    public void setTempleContactTel(String templeContactTel) {
        this.templeContactTel = templeContactTel == null ? null : templeContactTel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}