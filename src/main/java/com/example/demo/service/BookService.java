package com.example.demo.service;

import com.example.demo.repository.BookRepository;

public class BookService {
	
	private final LoggerService loggerService;
	private BookRepository bookrepository;
	
	public BookService(LoggerService loggerService) {
		this.loggerService = loggerService;
		
	}
	
	public void startLog() {
		loggerService.log("Message logged Exercise 2");
	}

}
