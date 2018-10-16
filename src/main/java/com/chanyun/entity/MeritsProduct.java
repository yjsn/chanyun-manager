package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("功德产品")
public class MeritsProduct {
	@ApiModelProperty(value = "主键id", readOnly = true)
    private Integer id;
	@ApiModelProperty(value = "寺庙id")
    private Integer templeId;
	@ApiModelProperty(value = "寺庙名称")
    private String templeName;
	@ApiModelProperty(value = "产品类型  1上香， 2佛灯， 3许愿， 4忏悔，5修行，6抄经，7捐助 ")
    private Integer meritsType;
	@ApiModelProperty(value = "产品名称")
    private String meritsName;
	@ApiModelProperty(value = "产品价格")
    private BigDecimal salePrice;
	@ApiModelProperty(value = "结算价格")
    private BigDecimal settlementPrice;
	@ApiModelProperty(value = "创建时间")
    private Date createTime;
	@ApiModelProperty(value = "状态 1有效，2无效")
    private Integer meritsStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName == null ? null : templeName.trim();
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

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMeritsStatus() {
        return meritsStatus;
    }

    public void setMeritsStatus(Integer meritsStatus) {
        this.meritsStatus = meritsStatus;
    }
}