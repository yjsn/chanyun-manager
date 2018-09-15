package com.chanyun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色实体类")
public class Role {
	@ApiModelProperty(value="角色id",readOnly=true,required=true)
    private Integer id;
	
	@ApiModelProperty("状态 0 启用 1禁用")
    private int status;
	@ApiModelProperty("角色名称")
    private String name;
	@ApiModelProperty("备注")
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}