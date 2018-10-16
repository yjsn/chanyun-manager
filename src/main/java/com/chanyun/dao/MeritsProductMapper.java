package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.MeritsProduct;
import com.github.pagehelper.Page;

public interface MeritsProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeritsProduct record);

    int insertSelective(MeritsProduct record);

    MeritsProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeritsProduct record);

    int updateByPrimaryKey(MeritsProduct record);
    
    /**
     * 条件查询功德项目列表
     * @param params
     * @return
     */
    List<MeritsProduct> queryByParams(MeritsProduct params);
    
    /**
     * 分页查询产品列表
     * @param params
     * @return
     */
    Page<MeritsProduct> queryByPage(MeritsProduct params);
}