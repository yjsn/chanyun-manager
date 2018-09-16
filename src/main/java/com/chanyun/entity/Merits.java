package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("用户功德(订单)信息")
public class Merits {
	@ApiModelProperty(value="功德id",readOnly=true,example="")
    private Integer id;
	@ApiModelProperty(value="功德编号",example="GD201809161312000001")
    private String meritsNumber;
	@ApiModelProperty(value="用户Id",example="10000000001")
    private Integer userId;
	@ApiModelProperty(value="功德人姓名",example="张三")
    private String customerName;
	@ApiModelProperty(value="功德人年龄-年",example="1980")
    private Integer customerYear;
	@ApiModelProperty(value="功德人年龄-月",example="02")
    private Integer customerMonth;
	@ApiModelProperty(value="功德人年龄-日",example="28")
    private Integer customerDay;
	@ApiModelProperty(value="功德人年龄-时",example="14")
    private String customerHour;
	@ApiModelProperty(value="功德人地址-省",example="上海")
    private String customerAddressProvince;
	@ApiModelProperty(value="功德人地址-市",example="上海")
    private String customerAddressCity;
	@ApiModelProperty(value="功德人地址-区/县",example="浦东新区")
    private String customerAddressArea;
	@ApiModelProperty(value="功德人地址-街道地址",example="惠南镇城西路118号")
    private String customerAddress;
	@ApiModelProperty(value="功德类型",example="1")
    private Integer meritsType;
	@ApiModelProperty(value="功德名称",example="请财富香")
    private String meritsName;
	@ApiModelProperty(value="功德数量",example="18")
    private Integer meritsAccount;
	@ApiModelProperty(value="寺庙id",example="1")
    private Integer templeId;
	@ApiModelProperty(value="菩萨名称",example="观音大士")
    private String godName;
	@ApiModelProperty(value="寺庙殿名",example="圆通宝殿")
    private String templeHouseName;
	@ApiModelProperty(value="功德事件状态 0 申请 1未支付 2进行中 3完成 4未完成 5退款 9异常",example="0")
    private Integer meritsStatus;
	@ApiModelProperty(value="申请时间",example="2018-09-16 14:00")
    private Date applyTime;
	@ApiModelProperty(value="完成时间",example="2018-09-17 14:00")
    private Date completionTime;
	@ApiModelProperty(value="预留字段",example="",hidden=true)
    private String var1;
	@ApiModelProperty(value="预留字段",example="",hidden=true)
    private String var2;

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

    public Integer getMeritsAccount() {
        return meritsAccount;
    }

    public void setMeritsAccount(Integer meritsAccount) {
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

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1 == null ? null : var1.trim();
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2 == null ? null : var2.trim();
    }
}