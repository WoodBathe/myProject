package com.qst.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qst.model.User;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		System.out.println("...preHandle...");
		
		HandlerMethod method = (HandlerMethod)arg2;
		System.out.println("methodName:"+method.getMethod().getName());
		System.out.println("beanName:"+method.getBean().getClass().getName());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mv)
			throws Exception {
		User user = new User();
		user.setUsername("ssss");
		user.setUserpass("555");
		mv.addObject(user);
		mv.setViewName("upload");
		System.out.println("...postHandle...");
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("...afterCompletion...");

	}

}
