package com.chanyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.Temple;
import com.chanyun.service.TempleService;


/**
 * 

* <p>Title: TempleController.java</p>  

* <p>Description: 寺庙数据操作接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月18日 

* @version 1.0
 */
@Api(tags="寺庙操作接口")
@RestController
@RequestMapping("/api/temple")
public class TempleController extends BaseController<Object> {
	@Autowired
	private TempleService templeService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="分页查询寺庙列表")
	@PostMapping("/templePage")
	@ResponseBody
	public BaseResult<PageInfo<Temple>> templePage(@RequestBody QueryParams<Temple> request){
		PageInfo<Temple> result = templeService.findTempleByPage(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="修改寺庙信息")
	@PostMapping("/edit")
	@ResponseBody
	public BaseResult<Temple> editTemple(@RequestBody Temple temple){
		boolean result = templeService.editTemple(temple);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", temple);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="添加寺庙信息")
	@PostMapping("/add")
	@ResponseBody
	public BaseResult<Temple> addTemple(@RequestBody Temple temple){
		Temple result = templeService.addTemple(temple);
		if(null != result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "添加成功", temple);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "添加失败", temple);
	}
	
	@ApiOperation(value="寺庙禁用接口")
	@PostMapping("/disableTemple")
	@ResponseBody
	public BaseResult<Temple> disableTemple(@RequestBody int templeId){
		Temple temple = new Temple();
		temple.setId(templeId);
		temple.setStatus(Constants.STATUS_DISABLE);
		boolean flag = templeService.editTemple(temple);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", temple);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "添加失败", temple);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="寺庙启用/审核通过 接口")
	@PostMapping("/ableTemple")
	@ResponseBody
	public BaseResult<Temple> ableTemple(@RequestBody int templeId){
		Temple temple = new Temple();
		temple.setId(templeId);
		temple.setStatus(Constants.STATUS_ABLE);
		boolean flag = templeService.editTemple(temple);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", temple);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "添加失败", temple);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="寺庙启用/审核通过 接口")
	@PostMapping("/checkFail")
	@ResponseBody
	public BaseResult<Temple> checkFail(@RequestBody int templeId){
		Temple temple = new Temple();
		temple.setId(templeId);
		temple.setStatus(Constants.STATUS_CHECK_FAIL);
		boolean flag = templeService.editTemple(temple);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", temple);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "添加失败", temple);
	}
}
