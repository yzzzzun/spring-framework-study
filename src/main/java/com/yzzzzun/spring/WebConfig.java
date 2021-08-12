package com.yzzzzun.spring;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yzzzzun.spring.filter.FirstLogFilter;
import com.yzzzzun.spring.filter.SecondLogFilter;
import com.yzzzzun.spring.interceptor.FirstLogInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public FilterRegistrationBean firstLogFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new FirstLogFilter());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean secondLogFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new SecondLogFilter());
		filterRegistrationBean.setOrder(2);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new FirstLogInterceptor())
			.order(1)
			.addPathPatterns("/**")
			.excludePathPatterns("/css/**", "/*.ico", "/error");
	}
}
