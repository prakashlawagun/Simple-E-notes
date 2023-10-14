package com.prakash.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.prakash.entity.User;

public class AuthHandler implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("loginuser");
		if(user != null) {
			return true;
		}else {
			response.getWriter().print("<h1>Please Login</h1>");
			return false;
		}
		
	}
	
	

}
