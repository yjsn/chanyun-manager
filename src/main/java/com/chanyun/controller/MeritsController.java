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
import com.chanyun.entity.Merits;
import com.chanyun.service.MeritsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="功德订单数据接口",tags="功德订单数据接口")
@RestController
@RequestMapping("/api/merits")
public class MeritsController extends BaseController<Object>{
	@Autowired
	private MeritsService meritsService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="分页查询功德订单列表")
	@PostMapping("/list")
	@ResponseBody
	public BaseResult<Merits> meritsList(@RequestBody QueryParams<Merits> request){
		PageInfo<Merits> result = meritsService.findByPage(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
}
