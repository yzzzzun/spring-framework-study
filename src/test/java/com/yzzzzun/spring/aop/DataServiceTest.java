package com.yzzzzun.spring.aop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yzzzzun.spring.aop.v2.DataLogDecorator;
import com.yzzzzun.spring.aop.v2.DataServiceTarget;

class DataServiceTest {

	@DisplayName("data service decorator")
	@Test
	void testDecorator () {
	    DataService dataService = new DataLogDecorator(new DataServiceTarget());
		dataService.addData("test");
		dataService.getData(1L);
		dataService.getDatas();
	}
}