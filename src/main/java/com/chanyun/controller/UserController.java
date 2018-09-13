package com.chanyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.OnlineMessage;
import com.chanyun.entity.User;
import com.chanyun.service.UserService;

/**
 * @Description:用户对外接口提供服务层
 * @author liuyang
 * @data  2017-6-17 上午10:10:32
 *
 */
@Api(value="用户信息管理")
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("/findUserList")
	@ApiOperation("分页查询用户信息列表")
	public BaseResult<PageInfo<User>> findUserByPage(@RequestBody QueryParams<User> request){
		User user = request.getBean();
		Map params = new HashMap<String, Object>();
		params.put("userAccount", user.getUserAccount());
		params.put("userPhone", user.getUserPhone());
		PageInfo<User> result = userService.findByPage(request.getPageNum(), request.getPageSize(), params);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
}
