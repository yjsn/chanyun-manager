package com.chanyun.controller;

import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.MerchantAccount;
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
	
	/**
	 * 添加商户
	 * @param user
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="添加商户接口")
	public BaseResult<String> add(@RequestBody MerchantAccount account){
		//设置注册时间
		account.setCreateTime(new Date());
		boolean reslut = merchantService.addMerchantAccount(account);
		if(reslut)
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "注册成功");
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "注册失败");
	}
	
	
	/**
	 * 查询商户列表
	 * @param request
	 * @return
	 */
	@PostMapping("/query")
	@ApiOperation(value="商户查询接口")
//	@ApiImplicitParam(value="商户查询返回结果",name="BaseResult",dataType="PageInfo<User>")
	public BaseResult<PageInfo<MerchantAccount>> queryBypage(@RequestBody QueryParams<MerchantAccount> request){
		Page<MerchantAccount> accounts = merchantService.queryMerchantByPage(request.getPageNum(), request.getPageSize(),request.getBean());
		PageInfo<MerchantAccount> result = new PageInfo<MerchantAccount>(accounts);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, result);
	}
	
	

}
