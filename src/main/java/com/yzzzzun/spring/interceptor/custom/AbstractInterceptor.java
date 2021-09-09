package com.yzzzzun.spring.interceptor.custom;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.GenericTypeResolver;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractInterceptor<T extends Annotation> implements HandlerInterceptor {

	private final Class<T> clazz;

	protected AbstractInterceptor() {
		this.clazz = (Class<T>)GenericTypeResolver.resolveTypeArgument(this.getClass(), AbstractInterceptor.class);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {

		if (isRegistedAnnotation(handler)) {
			return doPreHandle(request, response, handler);
		}

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		this.doPostHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {
		this.doAfterCompletion(request, response, handler, ex);
	}

	private boolean isRegistedAnnotation(Object handler) {
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Annotation[] annotations = handlerMethod.getMethod().getDeclaredAnnotations();

		return Arrays.stream(annotations)
			.anyMatch(annotation -> annotation.annotationType().isAssignableFrom(clazz));
	}

	abstract boolean doPreHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception;

	abstract void doPostHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception;

	abstract void doAfterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception;
}
