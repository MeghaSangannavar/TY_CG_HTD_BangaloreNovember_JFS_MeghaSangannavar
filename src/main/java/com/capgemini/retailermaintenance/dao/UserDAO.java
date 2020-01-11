package com.capgemini.retailermaintenance.dao;

import com.capgemini.retailermaintenance.dto.User;

public interface UserDAO {
	

    
	
	public boolean register(User user);
	
	public User login(User credentials);
	
	public boolean modifyPassword(String email, String password);
	
	

}
