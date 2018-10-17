package com.chanyun.controller;

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
import com.chanyun.entity.MeritsProduct;
import com.chanyun.service.MeritsProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "功德产品接口")
@RestController
@RequestMapping("/api/meritsProduct")
public class MeritsProductContoller extends BaseController {
	@Autowired
	private MeritsProductService meritsProductService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("分页列表查询")
	@PostMapping("page")
	@ResponseBody
	public BaseResult<PageInfo<MeritsProduct>> queryByPage(@RequestBody QueryParams<MeritsProduct> params){
		PageInfo<MeritsProduct> result = meritsProductService.queryByPage(params.getPageNum(), params.getPageSize(), params.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("添加功德项目")
	@PostMapping("add")
	@ResponseBody
	public BaseResult<MeritsProduct> addMeritsProduct(@RequestBody MeritsProduct meritsProduct){
		MeritsProduct result = meritsProductService.addMeritsProduct(meritsProduct);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "添加成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("编辑功德项目")
	@PostMapping("edit")
	@ResponseBody
	public BaseResult<String> editMeritsProduct(@RequestBody MeritsProduct meritsProduct){
		boolean result = meritsProductService.editMeritsProduct(meritsProduct);
		if(result) 
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", meritsProduct);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("禁用功德项目")
	@PostMapping("disable")
	@ResponseBody
	public BaseResult<MeritsProduct> disableMeritsProduct(@RequestBody MeritsProduct meritsProduct){
		MeritsProduct params = new MeritsProduct();
		params.setId(meritsProduct.getId());
		params.setMeritsStatus(Constants.STATUS_DISABLE);
		boolean result = meritsProductService.editMeritsProduct(params);
		if(result) meritsProduct = meritsProductService.queryById(meritsProduct.getId());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", meritsProduct);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("启用功德项目")
	@PostMapping("able")
	@ResponseBody
	public BaseResult<MeritsProduct> ableMeritsProduct(@RequestBody MeritsProduct meritsProduct){
		MeritsProduct params = new MeritsProduct();
		params.setId(meritsProduct.getId());
		params.setMeritsStatus(Constants.STATUS_ABLE);
		boolean result = meritsProductService.editMeritsProduct(params);
		if(result) meritsProduct = meritsProductService.queryById(meritsProduct.getId());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", meritsProduct);
	}
	
}
