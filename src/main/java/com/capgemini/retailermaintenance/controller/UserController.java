package com.capgemini.retailermaintenance.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenance.dto.User;
import com.capgemini.retailermaintenance.dto.UserResponse;
import com.capgemini.retailermaintenance.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody User user) {
		UserResponse response = new UserResponse();
		service.register(user);
		response.setStatusCode(201);
		response.setDescription("Success");
		response.setMessage("Account created");
		return response;
	}
	
	
	@PutMapping(path = "/modify-password",produces = MediaType.APPLICATION_JSON_VALUE,
		    consumes = MediaType.APPLICATION_JSON_VALUE)
public UserResponse modifyPassword(@RequestBody User user) {
	UserResponse response = new UserResponse();
	if(service.modifyPassword(user.getEmail(), user.getPassword())){
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDescription("password changed");
		
	}else {
		response.setStatusCode(401);
		response.setMessage("Failure");
		response.setDescription("password not  changed");
	}
	return response;
	} 
	
	
	

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody User credentials) {
		UserResponse response = new UserResponse();
		User account = service.login(credentials);
		if (account != null) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Logged in");
			
		} else {
			response.setStatusCode(405);
			response.setDescription("Failure");
			response.setMessage("Provide valid credentials");
		}
		return response;
	}

}
