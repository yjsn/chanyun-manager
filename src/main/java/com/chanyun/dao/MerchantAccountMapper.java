package com.chanyun.dao;

import com.chanyun.entity.MerchantAccount;
import com.github.pagehelper.Page;

public interface MerchantAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantAccount record);

    int insertSelective(MerchantAccount record);

    MerchantAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantAccount record);

    int updateByPrimaryKey(MerchantAccount record);
    /**
     * 分页查询数据
     * @return
     */
    Page<MerchantAccount> findByPage(MerchantAccount account);
}