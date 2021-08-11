package com.yzzzzun.spring.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondLogFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecondLogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("SecondLogFilter.init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		LOGGER.info("SecondLogFilter.doFilter");

		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String requestURI = httpRequest.getRequestURI();
		String uuid = UUID.randomUUID().toString();

		try {
			LOGGER.info("[[{}][{}]]", uuid, requestURI);
			chain.doFilter(request, response);
		} catch (Exception e) {
			throw e;
		} finally {
			LOGGER.info("[[{}][{}]]", uuid, requestURI);
		}
	}

	@Override
	public void destroy() {
		LOGGER.info("SecondLogFilter.destroy");
	}
}
