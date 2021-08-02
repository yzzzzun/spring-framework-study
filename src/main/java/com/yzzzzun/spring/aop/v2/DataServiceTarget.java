package com.yzzzzun.spring.aop.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yzzzzun.spring.aop.DataService;

public class DataServiceTarget implements DataService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataServiceTarget.class);
	private static final Map<Long, String> dataMap = new HashMap<>();
	private Long index = 0L;

	public List<String> getDatas(){
		return dataMap.keySet().stream()
			.map(dataMap::get)
			.collect(Collectors.toList());
	}

	public String getData(Long key){
		return dataMap.get(key);
	}

	public void addData(String data){
		dataMap.put(++index, data);
	}
}
