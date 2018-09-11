package com.chanyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.UserMapper;
import com.chanyun.entity.User;
import com.chanyun.service.MerchantService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 

* <p>Title: MerchantServiceImpl.java</p>  

* <p>Description: 商户数据服务提供类</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月11日 

* @version 1.0
 */
@Service
public class MerchantServiceImpl implements MerchantService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Page<User> queryMerchantByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return userMapper.findByPage();
	}

}
