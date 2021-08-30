package com.yzzzzun.spring.aop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.yzzzzun.spring.aop.v2.DataLogDecorator;
import com.yzzzzun.spring.aop.v2.DataServiceTarget;
import com.yzzzzun.spring.aop.v3.DataLogProxyFactoryBean;
import com.yzzzzun.spring.aop.v4.DataLogAdvice;

@SpringBootTest
class DataServiceTest {

	@Autowired
	private DataService dataService;

	@Autowired
	private ApplicationContext context;

	@DisplayName("data service decorator")
	@Test
	void testDecorator() {
		DataService dataService = new DataLogDecorator(new DataServiceTarget());
		dataService.addData("test");
		dataService.getData(1L);
		dataService.getDatas();
	}

	@DisplayName("dynamic proxy")
	@Test
	void testDynamicProxy() throws Exception {
		DataLogProxyFactoryBean bean = context.getBean(DataLogProxyFactoryBean.class);
		DataService service = (DataService)bean.getObject();

		service.addData("test");
		service.getData(1L);
		service.getDatas();
	}

	@DisplayName("aspect test")
	@Test
	void testAspect() {
		dataService.addData("test");
		dataService.getData(1L);
		dataService.getDatas();
	}

	@DisplayName("ProxyBeanFactory test")
	@Test
	void testProxyFactoryBean() {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(new DataServiceTarget());
		proxyFactoryBean.addAdvice(new DataLogAdvice());

		DataService service = (DataService)proxyFactoryBean.getObject();
		service.addData("test");
		service.getData(1L);
		service.getDatas();
	}

}