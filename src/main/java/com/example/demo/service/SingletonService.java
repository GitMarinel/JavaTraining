package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class SingletonService {
    public SingletonService() {
        System.out.println("SingletonService Created");
    }
    public void print() {
    	System.out.println("This is a SingletonService");
    }
}
