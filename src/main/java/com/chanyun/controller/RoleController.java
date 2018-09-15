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
import com.chanyun.entity.Role;
import com.chanyun.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="角色数据接口",tags="角色数据接口")
@RestController
@RequestMapping("/api/role")
public class RoleController extends BaseController<Object>{
	@Autowired
	private RoleService roleService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("获取角色列表")
	@PostMapping("roleList")
	@ResponseBody
	public BaseResult<PageInfo<Role>> findRoleByPage(@RequestBody QueryParams<Role> request){
		PageInfo<Role> result = roleService.findRoleListByPage(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("新增角色列表")
	@PostMapping("add")
	@ResponseBody
	public BaseResult<PageInfo<Role>> add(@RequestBody Role request){
		boolean flag = roleService.addRole(request);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "添加角色成功", null);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "添加角色失败，请重试", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("查询角色信息接口")
	@PostMapping("findRole")
	@ResponseBody
	public BaseResult<PageInfo<Role>> findRole(@RequestBody int roleId){
		Role result=roleService.findRoleById(roleId);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("修改角色接口")
	@PostMapping("edit")
	@ResponseBody
	public BaseResult<PageInfo<Role>> edit(@RequestBody Role request){
		boolean flag = roleService.editRole(request);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改角色成功", null);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改角色失败，请重试", null);
	}
}
