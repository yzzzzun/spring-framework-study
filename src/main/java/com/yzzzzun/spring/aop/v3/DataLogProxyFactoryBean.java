package com.yzzzzun.spring.aop.v3;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

public class DataLogProxyFactoryBean implements FactoryBean<Object> {

	private Object target;
	private Class<?> serviceInterface;

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setServiceInterface(Class<?> serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	@Override
	public Object getObject() throws Exception {

		DataLogHandler dataLogHandler = new DataLogHandler(target);

		return Proxy.newProxyInstance(getClass().getClassLoader(),
			new Class[] {serviceInterface},
			dataLogHandler);
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
