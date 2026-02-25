package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoggerService {
	
	public void log(String msg) {
		System.out.println("LOG:" + msg);
	
	}

}
