package com.yzzzzun.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzzzzun.spring.interceptor.annotation.CustomInterceptor;

@RestController
public class TestController {

	@GetMapping("/test")
	@CustomInterceptor
	public ResponseEntity<String> getTest() {
		return ResponseEntity.ok().body("test");
	}

	@GetMapping("/result")
	public ResponseEntity<String> getResult() {
		return ResponseEntity.ok().body("result");
	}
}
