package com.chanyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.User;
import com.chanyun.service.MerchantService;
import com.github.pagehelper.Page;

/**

* <p>Title: MerchantController.java</p>  

* <p>Description: 商户操作类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月10日  

* @version 1.0
 */
@Api(value="商户controller",tags={"商户操作接口"})
@RestController
@RequestMapping("merchant")
public class MerchantController extends BaseController{
	@Autowired
	private MerchantService merchantService;
	
	@PostMapping("/add")
	@ApiImplicitParam(name="OnlineMessage",value="商户信息",dataType="OnlineMessage")
	public BaseResult add(@RequestBody String onlineMessage){
		Page<User> result = merchantService.queryMerchantByPage(1, 2);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, result);
	}
	
	@PostMapping("/query")
//	@ApiImplicitParam(value="商户查询返回结果",name="BaseResult",dataType="PageInfo<User>")
	public BaseResult<PageInfo<User>> queryBypage(@RequestBody QueryParams<User> request){
		Page<User> users = merchantService.queryMerchantByPage(request.getPageNum(), request.getPageSize());
		PageInfo<User> result = new PageInfo<User>(users);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, result);
	}

}
