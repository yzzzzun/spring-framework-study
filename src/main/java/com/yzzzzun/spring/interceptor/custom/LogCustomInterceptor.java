package com.yzzzzun.spring.interceptor.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.yzzzzun.spring.interceptor.annotation.CustomInterceptor;

public class LogCustomInterceptor extends AbstractInterceptor<CustomInterceptor> {

	@Override
	boolean doPreHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LogCustomInterceptor.doPreHandle");
		return true;
	}

	@Override
	void doPostHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		System.out.println("LogCustomInterceptor.doPostHandle");
	}

	@Override
	void doAfterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {
		System.out.println("LogCustomInterceptor.doAfterCompletion");
	}
}