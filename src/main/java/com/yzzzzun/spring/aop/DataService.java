package com.yzzzzun.spring.aop;

import java.util.List;

public interface DataService {
	String getData(Long key);
	List<String> getDatas();
	void addData(String data);
}
