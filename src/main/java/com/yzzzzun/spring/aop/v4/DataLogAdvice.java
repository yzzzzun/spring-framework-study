package com.yzzzzun.spring.aop.v4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataLogAdvice implements MethodInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLogAdvice.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		LOGGER.info("start advice");
		Object result = invocation.proceed();
		LOGGER.info("end advice");
		return result;
	}
}
