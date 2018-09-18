package com.chanyun.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.MerchantAccountMapper;
import com.chanyun.dao.UserMapper;
import com.chanyun.entity.MerchantAccount;
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
	private MerchantAccountMapper accountMapper;
	
	@Override
	public Page<MerchantAccount> queryMerchantByPage(int pageNo, int pageSize,MerchantAccount account) {
		PageHelper.startPage(pageNo,pageSize);
		return accountMapper.findByPage(account);
	}

	@Override
	public MerchantAccount addMerchantAccount(MerchantAccount account) {
		int i = accountMapper.insertSelective(account);
		if(i>0)
			return account;
		return null;
	}
	
	@Override
	public boolean selectMerchantAccountIsSave(Map params) {
		int i=accountMapper.findCountByParams(params);
		if(i>0) return true;
		return false;
	}
	
	@Override
	public MerchantAccount queryMerchantAccountByParams(Map params) {
		
		return accountMapper.selectByParams(params);
	}
}
