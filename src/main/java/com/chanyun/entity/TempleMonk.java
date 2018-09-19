package com.chanyun.entity;

import java.util.Date;

public class TempleMonk {
    private Integer id;

    private Integer templeId;

    private String templeMonkName;

    private String templeMonkDesciption;

    private Integer sort;

    private String templeMonkCoverImg;

    private Integer status;

    private Date createTime;

    private String templeMonkIntroduce;

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

    public String getTempleMonkName() {
        return templeMonkName;
    }

    public void setTempleMonkName(String templeMonkName) {
        this.templeMonkName = templeMonkName == null ? null : templeMonkName.trim();
    }

    public String getTempleMonkDesciption() {
        return templeMonkDesciption;
    }

    public void setTempleMonkDesciption(String templeMonkDesciption) {
        this.templeMonkDesciption = templeMonkDesciption == null ? null : templeMonkDesciption.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTempleMonkCoverImg() {
        return templeMonkCoverImg;
    }

    public void setTempleMonkCoverImg(String templeMonkCoverImg) {
        this.templeMonkCoverImg = templeMonkCoverImg == null ? null : templeMonkCoverImg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTempleMonkIntroduce() {
        return templeMonkIntroduce;
    }

    public void setTempleMonkIntroduce(String templeMonkIntroduce) {
        this.templeMonkIntroduce = templeMonkIntroduce == null ? null : templeMonkIntroduce.trim();
    }
}