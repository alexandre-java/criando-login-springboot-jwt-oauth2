package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.RegisterInforUserDto;
import com.api.model.UserEntity;
import com.api.repository.RegisterUserRepository;




@RestController
public class RegisterController {
	
	@Autowired
    RegisterUserRepository repository;
	
    @PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody  RegisterInforUserDto registerInforUserDto){
    	try {
			UserEntity userInfo = new UserEntity();

			userInfo.setName(registerInforUserDto.name());
		    userInfo.setEmail(registerInforUserDto.email());
		    userInfo.setFone(registerInforUserDto.fone());
		    userInfo.setPassword(new BCryptPasswordEncoder().encode(registerInforUserDto.password()));
		    userInfo.setRole(registerInforUserDto.role());
		 
		    repository.save(userInfo);
		    return ResponseEntity.status(HttpStatus.CREATED).body("Account created!");
	    
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create account!");

		}
		
	}
}
