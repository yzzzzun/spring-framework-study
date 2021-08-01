package com.yzzzzun.spring.aop.v2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yzzzzun.spring.aop.DataService;

public class DataLogDecorator implements DataService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataLogDecorator.class);
	private final DataService dataService;

	public DataLogDecorator(DataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public String getData(Long key) {
		LOGGER.info("start");
		String result = dataService.getData(key);
		LOGGER.info("end");
		return result;
	}

	@Override
	public List<String> getDatas() {
		LOGGER.info("start");
		List<String> result = dataService.getDatas();
		LOGGER.info("end");
		return result;
	}

	@Override
	public void addData(String data) {
		LOGGER.info("start");
		dataService.addData(data);
		LOGGER.info("end");
	}
}
