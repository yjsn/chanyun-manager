package com.chanyun.service;


import java.util.Map;

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
	public MerchantAccount addMerchantAccount(MerchantAccount account);
	
	/**
	 * 查询商户数据是否存在
	 * @param params 查询条件
	 * @return	boolean 存在为true 不存在为false
	 */
	public boolean selectMerchantAccountIsSave(Map params);
	
	/**
	 * 查询商户数据
	 * @param params 查询条件
	 * @return 返回单条商户数据
	 */
	public MerchantAccount queryMerchantAccountByParams(Map params);
}
