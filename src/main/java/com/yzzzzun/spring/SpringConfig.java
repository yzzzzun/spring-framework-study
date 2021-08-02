package com.yzzzzun.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yzzzzun.spring.aop.v4.DataLogAop;

@Configuration
public class SpringConfig {

	@Bean
	public DataLogAop dataLogAop(){
		return new DataLogAop();
	}
}
