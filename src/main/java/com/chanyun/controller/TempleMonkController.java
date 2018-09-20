package com.chanyun.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
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
import com.chanyun.entity.MerchantAccount;
import com.chanyun.entity.TempleMonk;
import com.chanyun.service.TempleMonkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="寺庙僧人数据操作接口")
@RequestMapping("/api/templeMonk")
@RestController
public class TempleMonkController extends BaseController<Object> {
	@Autowired
	private TempleMonkService templeMonkService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("添加寺庙僧人接口")
	@PostMapping("add")
	@ResponseBody
	public BaseResult<TempleMonk> addTempleMonk(@RequestBody TempleMonk templeMonk,HttpServletRequest request){
		HttpSession session = request.getSession();
		MerchantAccount account = (MerchantAccount) session.getAttribute("merchantAccount");
		templeMonk.setTempleId(account.getTempleId());
		TempleMonk result = templeMonkService.add(templeMonk);
		if(null != result)
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "添加成功", result);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "添加失败", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("查询寺庙僧人列表接口")
	@PostMapping("queryPage")
	@ResponseBody
	public BaseResult<PageInfo<TempleMonk>> queryMonkList(@RequestBody QueryParams<TempleMonk> request){
		PageInfo<TempleMonk> result = templeMonkService.queryByPage(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("修改寺庙僧人接口")
	@PostMapping("edit")
	@ResponseBody
	public BaseResult<TempleMonk> edit(@RequestBody TempleMonk request){
		boolean flag = templeMonkService.edit(request);
		if(flag)
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", request);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("根据僧人id查询僧人信息")
	@PostMapping("queryById")
	@ResponseBody
	public BaseResult<TempleMonk> queryTempleMonk(@RequestBody int monkId){
		TempleMonk result = templeMonkService.queryById(monkId);
		if(null != result)
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "查询失败", null);
	}
}
