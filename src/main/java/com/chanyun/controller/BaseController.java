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
public class BaseController {
	
	/**
	 * 返回json数据组装
	 * @param code
	 * @param message
	 * @return
	 */
	public String returnBaseResult(String code,String message){
		BaseResult br = new BaseResult();
		br.setCode(code);
		br.setData(message);
		return JSONObject.toJSONString(br);
	}
}
