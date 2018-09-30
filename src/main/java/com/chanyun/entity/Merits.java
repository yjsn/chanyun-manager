package com.chanyun.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Merits {
    private Integer id;

    private String meritsNumber;

    private Integer userId;

    private String customerName;

    private Integer customerYear;

    private Integer customerMonth;

    private Integer customerDay;

    private String customerHour;

    private String customerAddressProvince;

    private String customerAddressCity;

    private String customerAddressArea;

    private String customerAddress;

    private Integer meritsProductId;

    private Integer meritsType;

    private String meritsName;

    private BigDecimal meritsAccount;

    private Integer templeId;

    private String godName;

    private String templeHouseName;

    private Integer meritsStatus;

    private Date applyTime;

    private Date completionTime;

    private String payType;

    private String payNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeritsNumber() {
        return meritsNumber;
    }

    public void setMeritsNumber(String meritsNumber) {
        this.meritsNumber = meritsNumber == null ? null : meritsNumber.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getCustomerYear() {
        return customerYear;
    }

    public void setCustomerYear(Integer customerYear) {
        this.customerYear = customerYear;
    }

    public Integer getCustomerMonth() {
        return customerMonth;
    }

    public void setCustomerMonth(Integer customerMonth) {
        this.customerMonth = customerMonth;
    }

    public Integer getCustomerDay() {
        return customerDay;
    }

    public void setCustomerDay(Integer customerDay) {
        this.customerDay = customerDay;
    }

    public String getCustomerHour() {
        return customerHour;
    }

    public void setCustomerHour(String customerHour) {
        this.customerHour = customerHour == null ? null : customerHour.trim();
    }

    public String getCustomerAddressProvince() {
        return customerAddressProvince;
    }

    public void setCustomerAddressProvince(String customerAddressProvince) {
        this.customerAddressProvince = customerAddressProvince == null ? null : customerAddressProvince.trim();
    }

    public String getCustomerAddressCity() {
        return customerAddressCity;
    }

    public void setCustomerAddressCity(String customerAddressCity) {
        this.customerAddressCity = customerAddressCity == null ? null : customerAddressCity.trim();
    }

    public String getCustomerAddressArea() {
        return customerAddressArea;
    }

    public void setCustomerAddressArea(String customerAddressArea) {
        this.customerAddressArea = customerAddressArea == null ? null : customerAddressArea.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public Integer getMeritsProductId() {
        return meritsProductId;
    }

    public void setMeritsProductId(Integer meritsProductId) {
        this.meritsProductId = meritsProductId;
    }

    public Integer getMeritsType() {
        return meritsType;
    }

    public void setMeritsType(Integer meritsType) {
        this.meritsType = meritsType;
    }

    public String getMeritsName() {
        return meritsName;
    }

    public void setMeritsName(String meritsName) {
        this.meritsName = meritsName == null ? null : meritsName.trim();
    }

    public BigDecimal getMeritsAccount() {
        return meritsAccount;
    }

    public void setMeritsAccount(BigDecimal meritsAccount) {
        this.meritsAccount = meritsAccount;
    }

    public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName == null ? null : godName.trim();
    }

    public String getTempleHouseName() {
        return templeHouseName;
    }

    public void setTempleHouseName(String templeHouseName) {
        this.templeHouseName = templeHouseName == null ? null : templeHouseName.trim();
    }

    public Integer getMeritsStatus() {
        return meritsStatus;
    }

    public void setMeritsStatus(Integer meritsStatus) {
        this.meritsStatus = meritsStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber == null ? null : payNumber.trim();
    }
}