package com.chanyun.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* <p>Title: BaseResult.java</p>  

* <p>Description: 返回通用实体类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月11日 

* @version 1.0
 */
@ApiModel("数据返回信息类")
public class BaseResult<T> {
	/**
	 * 返回码
	 */
	@ApiModelProperty(value="返回code码： 0000 成功  0001 失败 0002 参数较难错误 0004 服务端异常 0009 用户未登陆")
	private String code;
	
	/**
	 * 返回信息提示
	 */
	@ApiModelProperty(value="返回信息提示")
	private String message;
	
	/**
	 * 返回json数据
	 */
	@ApiModelProperty(value="返回数据")
	private T data;
	
	public BaseResult(){};
	
	public BaseResult(String code,String message,T data){
		this.code=code;
		this.data = data;
		this.message=message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}
