package com.yzzzzun.spring.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstLogInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstLogInterceptor.class);
	private static final String LOG_ID = "logId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {

		String requestURI = request.getRequestURI();
		String uuid = UUID.randomUUID().toString();

		request.setAttribute("logId", uuid);

		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod)handler;
		}

		LOGGER.info("preHandle : [[{}][{}][{}]]", uuid, requestURI, handler);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		LOGGER.info("postHandle : {}", modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {

		String requestURI = request.getRequestURI();
		String uuid = (String)request.getAttribute(LOG_ID);
		LOGGER.info("afterCompletion : [[{}][{}][{}]]", uuid, requestURI, handler);
		if (ex != null) {
			LOGGER.error("afterCompletion error", ex);
		}
	}
}
