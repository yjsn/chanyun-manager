package com.chanyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;

/**

* <p>Title: MerchantController.java</p>  

* <p>Description: 商户操作类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月10日  

* @version 1.0
 */
@Api(value="商户管理")
@RestController
@RequestMapping("merchant")
public class MerchantController extends BaseController{

	@PostMapping("/add")
	@ApiImplicitParam(name="OnlineMessage",value="商户信息",dataType="OnlineMessage")
	public String add(@RequestBody String onlineMessage){
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, onlineMessage);
	}
	
}
