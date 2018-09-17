package com.chanyun.controller;

import java.util.List;

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
import com.chanyun.entity.Menu;
import com.chanyun.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* <p>Title: MenuController.java</p>  

* <p>Description: 菜单操作接口</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月14日 

* @version 1.0
 */
@Api(value="菜单操作接口",tags="菜单操作接口")
@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("菜单列表查询")
	@PostMapping("/menuList")
	@ResponseBody
	public BaseResult<PageInfo<Menu>> queryMenuList(@RequestBody QueryParams<Menu> request){
		PageInfo<Menu> result = menuService.findMenuByPage(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("根据id查询菜单列表")
	@PostMapping("/queryMenu")
	@ResponseBody
	public BaseResult<Menu> queryMenu(@RequestBody int menuId){
		Menu result = menuService.findMenuById(menuId);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@ApiOperation("新增菜单")
	@PostMapping("/add")
	@ResponseBody
	public BaseResult<String> addMenu(@RequestBody Menu menu){
		boolean flag = menuService.addMenu(menu);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "新增菜单成功", null);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "新增菜单失败，请重试", null);
	}
	
	@ApiOperation("修改菜单")
	@PostMapping("/edit")
	@ResponseBody
	public BaseResult<String> editMenu(@RequestBody Menu menu){
		boolean flag = menuService.editMenu(menu);
		if(flag) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "修改菜单成功", null);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "修改菜单失败，请重试", null);
	}
	
	@ApiOperation("获取父级菜单列表")
	@PostMapping("/parentList")
	@ResponseBody
	public BaseResult<List<Menu>> queryParentMenuList(){
		List<Menu> result = menuService.queryParentMenuList();
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
}
