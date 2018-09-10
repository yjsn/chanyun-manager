package com.chanyun.common;

/**
 * 
 * @Description: 返回通用实体类
 * @author liuyang
 * @data  2017-6-17 上午10:31:11
 */
public class BaseResult {
	/**
	 * 返回码
	 */
	private String code;
	
	/**
	 * 返回json数据
	 */
	private String data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	
}
