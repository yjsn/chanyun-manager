package com.chanyun.dao;

import java.util.Map;

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
    
    /**
     * 根据条件查询数据是否存在
     * @param params
     * @return
     */
    int findCountByParams(Map params);
    
    /**
     * 查询商户数据
     * @param params
     * @return
     */
    MerchantAccount selectByParams(Map params);
}