package com.yzzzzun.spring.aop.v4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class DataLogAop {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLogAop.class);

	@Around("execution(* com.yzzzzun.spring.aop..*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("aop start");
		Object proceed = joinPoint.proceed();
		LOGGER.info("aop end");

		return proceed;
	}
}
