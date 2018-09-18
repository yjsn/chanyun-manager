package com.chanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.RoleMapper;
import com.chanyun.entity.Role;
import com.chanyun.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public PageInfo<Role> findRoleListByPage(int pageNum, int pageSize,
			Role role) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Role> roleList = roleMapper.selectByPage(role);
		PageInfo<Role> result = new PageInfo<Role>(roleList);
		return result;
	}

	@Override
	public Role findRoleById(int roleId) {
		Role result = roleMapper.selectByPrimaryKey(roleId);
		return result;
	}

	@Override
	public Role addRole(Role role) {
		int i = roleMapper.insertSelective(role);
		if(i>0) return role;
		return null;
	}

	@Override
	public boolean editRole(Role role) {
		int i = roleMapper.updateByPrimaryKeySelective(role);
		if(i>0) return true;
		return false;
	}

}
