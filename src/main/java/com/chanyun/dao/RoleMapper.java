package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.Role;
import com.github.pagehelper.Page;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * @Title: selectByMerchantId   
     * @Description: 查询用户角色集合 
     * @param: @param merchantId
     * @param: @return      
     * @return: List<Role>      
     * @throws
     */
    List<Role> selectByMerchantId(int merchantId);
    
    /**
     * 分页查询角色列表
     * @param role
     * @return
     */
    Page<Role> selectByPage(Role role);
}