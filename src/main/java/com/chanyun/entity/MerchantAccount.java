package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("商户实体类")
public class MerchantAccount {
	@ApiModelProperty(value="id",readOnly=true)
    private Integer id;
	@ApiModelProperty(value="账号")
    private String accountNumber;
	@ApiModelProperty(value="密码")
    private String accountPassword;
	@ApiModelProperty(value="用户名称")
    private String accountName;
	@ApiModelProperty(value="所属寺庙Id")
    private Integer templeId;
	@ApiModelProperty(value="状态 0 启用 1禁用")
    private Integer status;
	@ApiModelProperty(value="备注")
    private String remark;
	@ApiModelProperty(value="创建时间",readOnly=true)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}