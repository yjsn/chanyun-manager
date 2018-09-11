package com.chanyun.common;


/**
* <p>Title: BaseResult.java</p>  

* <p>Description: 返回通用实体类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月11日 

* @version 1.0
 */
public class BaseResult<T> {
	/**
	 * 返回码
	 */
	private String code;
	
	/**
	 * 返回json数据
	 */
	private T data;
	
	public BaseResult(){};
	
	public BaseResult(String code,T data){
		this.code=code;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	
	
}
