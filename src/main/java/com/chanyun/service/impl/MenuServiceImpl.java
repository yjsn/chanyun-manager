/**  

* <p>Title: MenuServiceImpl.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月12日  

* @version 1.0  

*/ 
package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.MenuMapper;
import com.chanyun.entity.Menu;
import com.chanyun.service.MenuService;

/**  

 * <p>Title: MenuServiceImpl.java</p>  

 * <p>Description: </p>  

 * <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

 * <p>Company: www.xinpiaoyuan.com</p>  

 * @author liuyang  

 * @date 2018年9月12日  

 * @version 1.0  

 */
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	/* (non-Javadoc)
	 * @see com.chanyun.service.MenuService#queryMenuByMerchantId(java.lang.Integer)
	 */
	@Override
	public List<Menu> queryMenuByMerchantId(Integer merchantId) {
		
		return menuMapper.selectMenuByMerchantId(merchantId);
	}

}
