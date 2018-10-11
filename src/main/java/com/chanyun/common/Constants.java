package com.chanyun.common;

/**
* <p>Title: Constants.java</p>  

* <p>Description:返回静态页面 配制 类 -重写WebMvcConfigurerAdapter类中的addViewControllers 方法 </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月11日 

* @version 1.0
 */
public class Constants {
	
	/**
	 * 返回码-成功
	 */
	public final static String RESULT_CODE_SUCCESS="0000";
	
	/**
	 * 返回码-失败
	 */
	public final static String RESULT_CODE_FAIL="0001";
	
	/**
	 *返回码-参数较验错误
	 */
	public final static String RESULT_CODE_CHECK_FAIL="0002";
	
	/**
	 * 异常码
	 */
	public final static String RESULT_CODE_CHECK_EXCEPTION="0004";
	
	/**
	 * 未登陆
	 */
	public final static String RESULT_CODE_LOGIN_OUT="0009";
	
	/**
	 * 禁用状态值
	 */
	public final static int STATUS_DISABLE=2;
	
	/**
	 * 启用状态值
	 */
	public final static int STATUS_ABLE=1;
	
	/**
	 * 审核未通过
	 */
	public final static int STATUS_CHECK_FAIL=3;
	
	/**
	 * 删除状态值
	 */
	public final static int STATUS_DELETE=99;
	
	/**
	 * 订单状态 申请
	 */
	public final static int MERITS_STATUS_APPLY=0;
	
	/**
	 * 订单状态 申请支付
	 */
	public final static int MERITS_STATUS_APPLY_PAY=1;
	
	/**
	 * 订单状态 已支付
	 */
	public final static int MERITS_STATUS_PAY=2;
	
	
	/**
	 * 订单状态  已完成
	 */
	public final static int MERITS_STATUS_COMPLETION=3;
	
	/**
	 * 订单状态 未完成
	 */
	public final static int MERITS_STATUS_FAIL=4;
	
	/**
	 * 订单状态 退款
	 */
	public final static int MERITS_STATUS_REFUND=5;
	
	/**
	 * 订单状态 订单异常
	 */
	public final static int MERITS_STATUS_EXCEPTION=9;
	
	
}
