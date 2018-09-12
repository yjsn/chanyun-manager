package com.chanyun.controller;

import springfox.documentation.annotations.ApiIgnore;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chanyun.common.BaseResult;

/**
 * @Description: controller 公共方法类
 * @author liuyang
 * @data  2017-6-17 上午10:36:51
 *
 */
@ApiIgnore
public class BaseController<T> {
	
	/**
	 * 返回json数据组装
	 * @param code
	 * @param message
	 * @param Object
	 * @return
	 */
	public BaseResult returnBaseResult(String code,String message,T object){
		BaseResult br = new BaseResult();
		br.setCode(code);
		br.setMessage(message);
		br.setData(object);
		return br;
	}
}
