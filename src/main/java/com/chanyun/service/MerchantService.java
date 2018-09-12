package com.chanyun.service;


import com.chanyun.entity.MerchantAccount;
import com.chanyun.entity.User;
import com.github.pagehelper.Page;

public interface MerchantService {
	/**
	 * 分页查询 
	 * @param pageNo 起始页
	 * @param pageSize	页面数据条数
	 * @param account	查询条件
	 * @return
	 */
	public Page<MerchantAccount> queryMerchantByPage(int pageNo, int pageSize,MerchantAccount account);
	
	/**
	 * 添加商户
	 * @param account
	 * @return
	 */
	public boolean addMerchantAccount(MerchantAccount account);
}
