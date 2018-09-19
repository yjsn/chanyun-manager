package com.chanyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.entity.TempleIntroduce;
import com.chanyun.service.TempleIntroduceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="寺庙主页内容")
@RestController
@RequestMapping("/api/templeIntroduce")
public class TempleIntroduceController extends BaseController<Object> {
	@Autowired
	private TempleIntroduceService templeIntroduceService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="根据寺庙Id查询寺庙简介信息")
	@PostMapping("/queryBytempleId")
	@ResponseBody
	public BaseResult<TempleIntroduce> queryTempleIntroduceBytTempleId(@RequestBody int templeId){
		TempleIntroduce result = templeIntroduceService.queryTempleIntroduceByTempleId(templeId);
		if(null != result.getId())
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS,"查询成功", result);
		return returnBaseResult(Constants.RESULT_CODE_FAIL,"查询失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("编辑寺庙简介")
	@PostMapping(value="/edit")
	@ResponseBody
	public BaseResult<TempleIntroduce> editTempleIntroduce(@RequestBody TempleIntroduce templeIntroduce){
		boolean flag = templeIntroduceService.edit(templeIntroduce);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS,"修改成功", templeIntroduce);
		return returnBaseResult(Constants.RESULT_CODE_FAIL,"查询失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("根据id查询寺庙简介信息")
	@PostMapping("/queryById")
	@ResponseBody
	public BaseResult<TempleIntroduce> queryTempleIntroduceById(@RequestBody int templeIntroduceId){
		TempleIntroduce result = templeIntroduceService.queryTempleInttroduceById(templeIntroduceId);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS,"查询成功", result);
	}
	
}
