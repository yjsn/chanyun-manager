package com.chanyun.service;


import com.chanyun.entity.User;
import com.github.pagehelper.Page;

public interface MerchantService {
	public Page<User> queryMerchantByPage(int pageNo, int pageSize);
}
