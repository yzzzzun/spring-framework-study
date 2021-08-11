package com.yzzzzun.spring;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yzzzzun.spring.filter.FirstLogFilter;
import com.yzzzzun.spring.filter.SecondLogFilter;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean firstLogFilter(){
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new FirstLogFilter());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean secondLogFilter(){
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new SecondLogFilter());
		filterRegistrationBean.setOrder(2);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
