package com.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@CurrentSecurityContext(expression = "authentication.name") String name) {
		
		return "Hello " + name;
	}

}
