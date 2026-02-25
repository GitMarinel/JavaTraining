package com.example.demo.service;


public class BookService {
	
	private final LoggerService loggerService;
	public BookService(LoggerService loggerService) {
		this.loggerService = loggerService;
		
	}
	
	public void startLog() {
		loggerService.log("Message logged Exercise 2");
	}
}
