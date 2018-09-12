package com.chanyun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
            if(session.getAttribute("merchantAccount") == null){
            	response.sendRedirect(request.getContextPath()+"/index.html");
                return false;
            }else{
                session.setAttribute("merchantAccount", session.getAttribute("merchantAccount"));
                return true;
            }
	}
}
