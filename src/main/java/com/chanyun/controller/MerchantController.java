package com.chanyun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.Menu;
import com.chanyun.entity.MerchantAccount;
import com.chanyun.entity.Temple;
import com.chanyun.entity.TempleIntroduce;
import com.chanyun.service.MenuService;
import com.chanyun.service.MerchantService;
import com.chanyun.service.TempleIntroduceService;
import com.chanyun.service.TempleService;
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
@RequestMapping("/api/merchant")
public class MerchantController extends BaseController<Object>{
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private TempleIntroduceService templeIntroduceService;
	@Autowired
	private TempleService templeService;
	
	/**
	 * 添加商户
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	@PostMapping("/add")
	@ApiOperation(value="添加商户接口")
	@ResponseBody
	public BaseResult<MerchantAccount> add(@RequestBody MerchantAccount account,HttpServletRequest request){
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("accountNumber", account.getAccountNumber());
		boolean isExist=merchantService.selectMerchantAccountIsSave(queryParams);
		if(isExist) return returnBaseResult(Constants.RESULT_CODE_FAIL, "用户名已经存在，请重新输入用户名称",null);
		//设置注册时间
		account.setCreateTime(new Date());
		MerchantAccount result = merchantService.addMerchantAccount(account);
		if(null != result){//注册成功添加寺庙简介
			TempleIntroduce templeIntroduce = new TempleIntroduce();
			Temple temple = templeService.queryById(account.getTempleId());
			templeIntroduce.setTempleId(temple.getId());
			templeIntroduce.setTempleName(temple.getTempleName());
			templeIntroduceService.add(templeIntroduce);
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "注册成功",result);
		}
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "注册失败",null);
	}
	
	
	/**
	 * 查询商户列表
	 * @param request
	 * @return
	 */
	@PostMapping("/query")
	@ApiOperation(value="商户查询接口")
	@SuppressWarnings("unchecked")
	@ResponseBody
//	@ApiImplicitParam(value="商户查询返回结果",name="BaseResult",dataType="PageInfo<User>")
	public BaseResult<PageInfo<MerchantAccount>> queryBypage(@RequestBody QueryParams<MerchantAccount> request){
		Page<MerchantAccount> accounts = merchantService.queryMerchantByPage(request.getPageNum(), request.getPageSize(),request.getBean());
		PageInfo<MerchantAccount> result = new PageInfo<MerchantAccount>(accounts);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS,"查询成功",result);
	}
	
	/**
	 * 登陆
	 * @param account
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ApiOperation(value="用户登陆接口")
	@PostMapping("/login")
	@ResponseBody
	//TODO 单机登陆，后期部署需要换成redis记录登陆状态
	public BaseResult<MerchantAccount> login(@RequestBody MerchantAccount account,HttpServletRequest request){
		Map<String, Object> queryParams = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MerchantAccount result =(MerchantAccount) session.getAttribute("merchantAccount");
		if(null != result){
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "用户已经登陆",result);
		}
		if(null == account || account.getAccountNumber().isEmpty() || account.getAccountPassword().isEmpty()){
			return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "账号或密码不能空",null);
		}
		queryParams.put("accountNumber", account.getAccountNumber());
		queryParams.put("accountPassword", account.getAccountPassword());
		result=merchantService.queryMerchantAccountByParams(queryParams);
		if(null == result){
			return returnBaseResult(Constants.RESULT_CODE_FAIL, "账号不存在，或密码错误",null);
		}
		if(result.getStatus() != 1){
			return returnBaseResult(Constants.RESULT_CODE_FAIL, "账号已经被封禁，请联系网站管理员！",null);
		}
		session.setAttribute("merchantAccount", result);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "登陆成功",null);
	}

	@SuppressWarnings("unchecked")
	@ApiOperation(value="用户权限查询")
	@PostMapping("/permission")
	@ResponseBody
	public BaseResult<List<Menu>> queryUserPermission(HttpServletRequest request){
		HttpSession session = request.getSession();
		MerchantAccount account =(MerchantAccount) session.getAttribute("merchantAccount");
		if(null == account)
			return returnBaseResult(Constants.RESULT_CODE_LOGIN_OUT, "未登陆",null);
		
		//获取用户权限
		int merchantId = account.getId();
		List<Menu> result = menuService.queryMenuByMerchantId(merchantId);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "登陆成功",result);
	}
	
	@ApiOperation("退出登陆接口")
	@PostMapping("loginOut")
	@ResponseBody
	public BaseResult<String> loginOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("merchantAccount", null);
		return  returnBaseResult(Constants.RESULT_CODE_SUCCESS, "用户已经退出登陆",null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiIgnore
	@ApiOperation(value="用户登陆测试接口")
	@PostMapping("/loginTest")
	@ResponseBody
	//TODO 正式联调删除
	public BaseResult<MerchantAccount> login( String accountNumber, String accountPassword,HttpServletRequest request){
		Map<String, Object> queryParams = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MerchantAccount result =(MerchantAccount) session.getAttribute("merchantAccount");
		if(null != result){
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "用户已经登陆",result);
		}
		if(accountNumber.isEmpty() || accountPassword.isEmpty()){
			return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "账号或密码不能空",null);
		}
		queryParams.put("accountNumber", accountNumber);
		queryParams.put("accountPassword", accountPassword);
		result=merchantService.queryMerchantAccountByParams(queryParams);
		if(null == result){
			return returnBaseResult(Constants.RESULT_CODE_FAIL, "账号不存在，或密码错误",null);
		}
		if(result.getStatus() != 0){
			return returnBaseResult(Constants.RESULT_CODE_FAIL, "账号已经被封禁，请联系网站管理员！",null);
		}
		session.setAttribute("merchantAccount", result);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "登陆成功",null);
	}
	
	
}
