package com.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.LoginAuthenticationDto;
import com.api.model.UserEntity;
import com.api.service.GenerateJwtService;


@RestController
public class LoginController {
	
	 @Autowired
	 GenerateJwtService generateJwtService;
     @Autowired
	 AuthenticationManager authenticationManager;
     
	


	
	
	
    @PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody  LoginAuthenticationDto loginAuthenticationDto) {
	   try {
    	  var usernamePassword = new UsernamePasswordAuthenticationToken(loginAuthenticationDto.email(), loginAuthenticationDto.password());
    	  var authentication = this.authenticationManager.authenticate(usernamePassword);
    	  var jwt = generateJwtService.tokenValid((UserEntity)authentication.getPrincipal());
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(jwt);
    	  
		}catch (AuthenticationException e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
			
		} 
	}

}
