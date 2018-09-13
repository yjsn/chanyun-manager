package com.chanyun.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.UserMapper;
import com.chanyun.entity.User;
import com.chanyun.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public PageInfo<User> findByPage(int pageNum, int pageSize,Map params) {
		PageHelper.startPage(pageNum, pageSize);
		Page<User> sqlResult = userMapper.selectByPage(params);
		PageInfo<User> result = new PageInfo<User>(sqlResult);
		return result;
	}

}
