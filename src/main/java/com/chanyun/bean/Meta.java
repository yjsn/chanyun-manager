package com.chanyun.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("前端路菜单内容")
public class Meta {
	@ApiModelProperty("菜单名称")
	private String title;
	@ApiModelProperty("菜单icon")
	private String icon;
	@ApiModelProperty("面包屑关联上级")
	private Route parents;
	
	public String getTitle() {
		return title;
	}
	public String getIcon() {
		return icon;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}