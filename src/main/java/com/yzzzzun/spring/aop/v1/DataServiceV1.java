package com.yzzzzun.spring.aop.v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataServiceV1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataServiceV1.class);
	private static final Map<Long, String> dataMap = new HashMap<>();
	private Long index = 0L;

	public List<String> getDatas(){
		LOGGER.info("start");
		List<String> result = dataMap.keySet().stream()
			.map(dataMap::get)
			.collect(Collectors.toList());
		LOGGER.info("end");
		return result;
	}

	public String getData(Long key){
		LOGGER.info("start");
		String result = dataMap.get(key);
		LOGGER.info("end");
		return result;
	}

	public void addData(String data){
		LOGGER.info("start");
		dataMap.put(++index, data);
		LOGGER.info("end");
	}

}
