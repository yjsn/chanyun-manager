package com.chanyun.dao;

import java.util.List;

import com.chanyun.entity.Menu;
import com.github.pagehelper.Page;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    /**
     * @Title: selectByParams   
     * @Description: 查询用户权限
     * @param: @param merchantId 用户id
     * @param: @return      
     * @return: List<Menu>      
     * @throws
     */
    List<Menu> selectMenuByMerchantId(int merchantId);
    
    /**
     * 分页查询菜单列表
     * @param menu
     * @return
     */
    Page<Menu> selectMenuByPage(Menu menu);
}