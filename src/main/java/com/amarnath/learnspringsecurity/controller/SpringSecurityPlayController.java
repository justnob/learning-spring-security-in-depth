package com.amarnath.learnspringsecurity.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayController {
	
	@GetMapping("/csrf-token")
	private CsrfToken GetCsrfTocken(HttpServletRequest request) {
		
		return (CsrfToken) request.getAttribute("_csrf");
		
	}

}
