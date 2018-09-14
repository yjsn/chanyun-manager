package com.chanyun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
			//获取session
        	HttpSession session = request.getSession();
        	//判断用户是否存在，不存在就跳转到登录界面
        	String origin = request.getHeader("Origin");
        	response.setHeader("Access-Control-Allow-Origin", origin);
        	response.setHeader("Access-Control-Allow-Methods", "*");
        	response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("contentType", "application/json;charset=utf-8");
            if(session.getAttribute("merchantAccount") == null){
            	BaseResult<String> result = new BaseResult<String>();
            	result.setCode(Constants.RESULT_CODE_LOGIN_OUT);
            	result.setMessage("用户未登陆");
            	result.setData(null);
            	response.getWriter().print(JSON.toJSON(result));
                return false;
            }else{
                session.setAttribute("merchantAccount", session.getAttribute("merchantAccount"));
                return true;
            }
	}
}
