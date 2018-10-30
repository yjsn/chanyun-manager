package com.chanyun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.chanyun.entity.Merits;
import com.chanyun.entity.MeritsDetail;
import com.chanyun.service.MeritsDetailService;
import com.chanyun.service.MeritsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="功德订单数据接口",tags="功德订单数据接口")
@RestController
@RequestMapping("/api/merits")
public class MeritsController extends BaseController<Object>{
	@Autowired
	private MeritsService meritsService;
	@Autowired
	private MeritsDetailService meritsDetailService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="分页查询功德订单列表")
	@PostMapping("/list")
	@ResponseBody
	public BaseResult<Merits> meritsList(@RequestBody QueryParams<Merits> request){
		PageInfo<Merits> result = meritsService.findByPage(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="分页查询寺庙功德订单列表")
	@PostMapping("/templeList")
	@ResponseBody
	public BaseResult<Merits> templeList(@RequestBody QueryParams<Merits> merits, HttpServletRequest request){
		HttpSession session = request.getSession();
		MerchantAccount merchantAccount = (MerchantAccount) session.getAttribute("merchantAccount");
		if(null == merchantAccount) return returnBaseResult(Constants.RESULT_CODE_FAIL, "查询失败", null);
		Merits params = merits.getBean();
		params.setTempleId(merchantAccount.getTempleId());
		PageInfo<Merits> result = meritsService.findByPage(merits.getPageNum(), merits.getPageSize(), merits.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value= "订单回执接口")
	@PostMapping("/completion")
	@ResponseBody
	public BaseResult<MeritsDetail> meritsCompletion(@RequestBody MeritsDetail meritsDetail, HttpServletRequest request){
		HttpSession session = request.getSession();
		MerchantAccount merchantAccount = (MerchantAccount) session.getAttribute("merchantAccount");
		if(null == merchantAccount) return returnBaseResult(Constants.RESULT_CODE_FAIL, "用户信息错误", null);
		Merits merits = meritsService.findById(meritsDetail.getMeritsId());
		if(merits.getTempleId().compareTo(merchantAccount.getTempleId()) != 0 && merchantAccount.getTempleId() != 0) //校验用户账号与订单是否关联,0为超级管理用户
			return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "修改失败,用户无权限修改此订单信息", null);
		//更新订单详情信息
		MeritsDetail meritsDetailResult = meritsDetailService.updateOrInsertMertsDetail(meritsDetail);
		if(null == meritsDetailResult) return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改失败", null);
		//更新功德订单信息
		Merits updateMeritsParams = new Merits();
		updateMeritsParams.setMeritsStatus(Constants.MERITS_STATUS_COMPLETION);
		updateMeritsParams.setId(merits.getId());
		boolean meritsFlag = meritsService.updateMerits(updateMeritsParams);
		if(!meritsFlag) return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改失败", null);
		meritsDetailResult.setMerits(merits);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改成功", meritsDetailResult);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value= "订单详情查询")
	@PostMapping("/meritsDetail")
	@ResponseBody
	public BaseResult<MeritsDetail> getMertisDetail(@RequestBody Merits merits){
		MeritsDetail meritsDetail = meritsDetailService.queryMeritsDetailByMeritsId(merits.getId());
		if(null != meritsDetail) {
			Merits meritsChild = meritsService.findById(merits.getId());
			meritsDetail.setMerits(meritsChild);
		}
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", meritsDetail);
	}
	
}
