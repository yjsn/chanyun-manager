package com.chanyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@ApiOperation("分页列表查询")
	@PostMapping("page")
	public BaseResult<PageInfo<MeritsProduct>> queryByPage(@RequestBody QueryParams<MeritsProduct> params){
		PageInfo<MeritsProduct> result = meritsProductService.queryByPage(params.getPageSize(), params.getPageNum(), params.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	
}
