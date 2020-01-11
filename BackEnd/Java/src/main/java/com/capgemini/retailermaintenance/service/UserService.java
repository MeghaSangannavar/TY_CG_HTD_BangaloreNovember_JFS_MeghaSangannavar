package com.capgemini.retailermaintenance.service;

import com.capgemini.retailermaintenance.dto.User;

public interface UserService {
	
public boolean register(User user);
	
	public User login(User credentials);
	
	public boolean modifyPassword(String email, String password);

}
