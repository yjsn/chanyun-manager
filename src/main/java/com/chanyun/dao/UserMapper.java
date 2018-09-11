package com.chanyun.dao;

import com.chanyun.entity.User;
import com.github.pagehelper.Page;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 分页查询数据
     * @return
     */
    Page<User> findByPage();
}