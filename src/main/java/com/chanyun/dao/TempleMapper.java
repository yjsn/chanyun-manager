package com.chanyun.dao;

import com.chanyun.entity.Temple;

public interface TempleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Temple record);

    int insertSelective(Temple record);

    Temple selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Temple record);

    int updateByPrimaryKey(Temple record);
}