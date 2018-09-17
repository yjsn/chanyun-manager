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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.MenuMapper;
import com.chanyun.entity.Menu;
import com.chanyun.service.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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

	@Override
	public PageInfo<Menu> findMenuByPage(int pageNum, int pageSize, Menu menu) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Menu> page = menuMapper.selectMenuByPage(menu);
		PageInfo<Menu> result = new PageInfo<Menu>(page);
		return result;
	}

	@Override
	public Menu findMenuById(int id) {
		
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean addMenu(Menu menu) {
		int i = menuMapper.insert(menu);
		if(i >0 ) return true;
		return false;
	}

	@Override
	public boolean editMenu(Menu menu) {
		int i = menuMapper.updateByPrimaryKeySelective(menu);
		if(i >0 ) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.chanyun.service.MenuService#queryParentMenuList()
	 */
	@Override
	public List<Menu> queryParentMenuList() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", -1);
		List<Menu> result = menuMapper.selectMenuByparams(params);
		return result;
	}

}
