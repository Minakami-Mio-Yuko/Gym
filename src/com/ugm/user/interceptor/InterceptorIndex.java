package com.ugm.user.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ugm.user.domain.User;


public class InterceptorIndex  implements HandlerInterceptor {

	private static final String[] IGNORE_URI ={
			"/index","/login","/register"};

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, 
			Object handler, Exception exception)
			throws Exception {}	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler, ModelAndView mv) throws Exception {
    	User user = (User) request.getSession().getAttribute("user");    	
		if(user == null) {
			mv.addObject("messageLogin","先登录才能访问本网站内容");
		}
	}	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,Object handler) throws Exception {
		boolean flag = false; 
		//获取请求的路径进行判断
		String servletPath = request.getServletPath();
    	User user = (User) request.getSession().getAttribute("user");
		
		// 判断请求是否需要拦截
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag){
        	if(user == null){   
        		if(servletPath.length()>11) {
                 	response.sendRedirect("../index");	
        		}
        		else {
                 	response.sendRedirect("index");	
        		}
        	}
        	else{        		
        		flag = true;       		
        	}   
        }
        return flag;		
	}
}
