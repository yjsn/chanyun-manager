package com.chanyun.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("前端路由对象")
public class Route {
	@ApiModelProperty("")
	private String path;
	
	private String component;
	
	private String redirect;
	
	private String name;
	
	private boolean alwaysShow;
	
	private Meta meta;
	
	
	
}
