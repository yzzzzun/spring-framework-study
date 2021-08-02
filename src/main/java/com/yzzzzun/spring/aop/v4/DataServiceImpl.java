package com.yzzzzun.spring.aop.v4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yzzzzun.spring.aop.DataService;

@Service
public class DataServiceImpl implements DataService {
	private static final Map<Long, String> dataMap = new HashMap<>();
	private Long index = 0L;

	@Override
	public List<String> getDatas(){
		return dataMap.keySet().stream()
			.map(dataMap::get)
			.collect(Collectors.toList());
	}

	@Override
	public String getData(Long key){
		return dataMap.get(key);
	}

	@Override
	public void addData(String data){
		dataMap.put(++index, data);
	}
}
