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
	public List<Menu> queryMenuByMerchantId(Integer merchantId);
}
