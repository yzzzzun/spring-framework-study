package com.yzzzzun.spring.aop;

import java.lang.reflect.Proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yzzzzun.spring.aop.v2.DataLogDecorator;
import com.yzzzzun.spring.aop.v2.DataServiceTarget;
import com.yzzzzun.spring.aop.v3.DataLogHandler;

@SpringBootTest
class DataServiceTest {

	@Autowired
	private DataService dataService;

	@DisplayName("data service decorator")
	@Test
	void testDecorator () {
	    DataService dataService = new DataLogDecorator(new DataServiceTarget());
		dataService.addData("test");
		dataService.getData(1L);
		dataService.getDatas();
	}

	@DisplayName("dynamic proxy")
	@Test
	void testDynamicProxy() {
		DataService dataService = (DataService)Proxy.newProxyInstance(getClass().getClassLoader(),
			new Class[] {DataService.class},
			new DataLogHandler(new DataServiceTarget()));

		dataService.addData("test");
		dataService.getData(1L);
		dataService.getDatas();
	}

	@DisplayName("aspect test")
	@Test
	void testAspect() {
		dataService.addData("test");
		dataService.getData(1L);
		dataService.getDatas();
	}
}