package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.service.BookService;
import com.example.demo.service.LoggerService;
import com.example.demo.service.PrototypeService;
import com.example.demo.service.SingletonService;



@SpringBootApplication
public class M8Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(M8Application.class, args);
		LoggerService loggerService = new LoggerService();
		BookService service = new BookService(loggerService);
		
		service.startLog();
		
		// Get Singleton Beans
        SingletonService s1 = context.getBean(SingletonService.class);
        SingletonService s2 = context.getBean(SingletonService.class);
        // Get Prototype Beans
        PrototypeService p1 = context.getBean(PrototypeService.class);
        PrototypeService p2 = context.getBean(PrototypeService.class);
        
        System.out.println("Singleton Same? " + (s1 == s2));
        System.out.println("Prototype Same? " + (p1 == p2));
        
        
	}

}
