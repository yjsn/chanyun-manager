/**  

* <p>Title: MenuService.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月12日  

* @version 1.0  

*/ 
package com.chanyun.service;

import java.util.List;
import java.util.Map;

import com.chanyun.bean.Route;
import com.chanyun.common.PageInfo;
import com.chanyun.entity.Menu;

/**  

 * <p>Title: MenuService.java</p>  

 * <p>Description: 菜单栏数据接口</p>  

 * <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

 * <p>Company: www.xinpiaoyuan.com</p>  

 * @author liuyang  

 * @date 2018年9月12日  

 * @version 1.0  

 */
public interface MenuService {
	/**
	 * 
	 * @Title: queryMenuByMerchantId   
	 * @Description: 根据用户id查询用户权限 
	 * @param: @param merchantId
	 * @param: @return      
	 * @return: List<Menu>      
	 * @throws
	 */
	public List<Route> queryMenuByMerchantId(Integer merchantId);
	
	/**
	 * 分页查询菜单列表
	 * @param pageNum 	起始页
	 * @param pageSize	页面展示数据条数
	 * @param menu		查询条件
	 * @return
	 */
	public PageInfo<Menu> findMenuByPage(int pageNum,int pageSize,Menu menu);
	
	/**
	 * 根据id查询菜单
	 * @param id 菜单id
	 * @return
	 */
	public Menu findMenuById(int id);
	
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	public Menu addMenu(Menu menu);
	
	/**
	 * 更新菜单数据
	 * @param menu
	 * @return
	 */
	public boolean editMenu(Menu menu);
	
	/**
	 * 
	 * @Title: queryParentMenuList   
	 * @Description: 查询父级菜单列表  
	 * @param: @return      
	 * @return: List<Menu>      
	 * @throws
	 */
	public List<Menu> queryParentMenuList();
}
