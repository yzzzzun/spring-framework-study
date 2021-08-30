package com.yzzzzun.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yzzzzun.spring.aop.DataService;
import com.yzzzzun.spring.aop.v2.DataServiceTarget;
import com.yzzzzun.spring.aop.v3.DataLogProxyFactoryBean;
import com.yzzzzun.spring.aop.v5.DataLogAop;

@Configuration
public class SpringConfig {

	@Bean
	public DataLogAop dataLogAop() {
		return new DataLogAop();
	}

	@Bean
	public DataLogProxyFactoryBean dataLogProxyFactoryBean() {
		DataLogProxyFactoryBean dataLogProxyFactoryBean = new DataLogProxyFactoryBean();
		dataLogProxyFactoryBean.setServiceInterface(DataService.class);
		dataLogProxyFactoryBean.setTarget(new DataServiceTarget());
		return dataLogProxyFactoryBean;
	}
	
}
