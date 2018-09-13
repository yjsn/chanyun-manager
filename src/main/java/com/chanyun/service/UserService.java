package com.chanyun.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.OnlineMessageMapper;
import com.chanyun.dao.UserMapper;
import com.chanyun.entity.OnlineMessage;
import com.chanyun.entity.User;

/**
* <p>Title: UserService.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月13日 

* @version 1.0
 */
public interface UserService {
	
	/**
	 * 查询用户
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public PageInfo<User> findByPage(int pageNo, int pageSize,Map params);
}
