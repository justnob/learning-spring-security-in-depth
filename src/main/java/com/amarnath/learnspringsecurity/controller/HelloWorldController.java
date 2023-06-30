package com.amarnath.learnspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarnath.learnspringsecurity.classes.HelloBean;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	private String GetHelloMessage() {
		
		return "Hello welcome to spring security learning process";
		
	}
	
	@GetMapping("/hello-bean")
	private HelloBean GetHellobean() {
		
		return new HelloBean("Amarnath Sah");
		
	}

}
