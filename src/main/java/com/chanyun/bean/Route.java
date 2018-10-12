package com.chanyun.bean;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("前端路由对象")
public class Route {
	@ApiModelProperty("菜单路径")
	private String path;
	@ApiModelProperty("菜单子级")
	private List<Route> children;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Route> getChildren() {
		return children;
	}
	public void setChildren(List<Route> children) {
		this.children = children;
	}
	
	
	
}
