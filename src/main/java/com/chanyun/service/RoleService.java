package com.chanyun.service;

import com.chanyun.common.PageInfo;
import com.chanyun.entity.Role;

/**
 * 

* <p>Title: RoleService.java</p>  

* <p>Description: 角色服务类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月15日 

* @version 1.0
 */
public interface RoleService {
	
	/**
	 * 根据条件分页查询角色列表
	 * @param pageNum  页码
	 * @param pageSize 页面数据展示条数
	 * @param role		查询条件
	 * @return
	 */
	public PageInfo<Role> findRoleListByPage(int pageNum,int pageSize,Role role);
	
	/**
	 * 根据id查询role
	 * @param roleId 
	 * @return
	 */
	public Role findRoleById(int roleId);
	
	/**
	 * 新增Role数据
	 * @param role
	 * @return
	 */
	public Role addRole(Role role);
	
	/**
	 * 修改role数据
	 * @param role
	 * @return
	 */
	public boolean editRole(Role role);
	
}
