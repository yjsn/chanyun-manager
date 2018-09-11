package com.chanyun.dao;

import com.chanyun.entity.IndexBanner;

public interface IndexBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexBanner record);

    int insertSelective(IndexBanner record);

    IndexBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexBanner record);

    int updateByPrimaryKey(IndexBanner record);
}