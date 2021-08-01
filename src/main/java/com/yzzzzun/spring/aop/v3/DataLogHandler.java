package com.yzzzzun.spring.aop.v3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yzzzzun.spring.aop.DataService;

public class DataLogHandler implements InvocationHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLogHandler.class);
	private final DataService target;

	public DataLogHandler(DataService target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		LOGGER.info("start");
		Object result = method.invoke(target, args);
		LOGGER.info("end");
		return result;
	}
}
