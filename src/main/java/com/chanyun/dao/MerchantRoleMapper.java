package com.chanyun.dao;

import com.chanyun.entity.MerchantRole;

public interface MerchantRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantRole record);

    int insertSelective(MerchantRole record);

    MerchantRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantRole record);

    int updateByPrimaryKey(MerchantRole record);
    
}