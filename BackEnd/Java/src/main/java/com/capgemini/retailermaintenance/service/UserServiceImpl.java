package com.capgemini.retailermaintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenance.dao.UserDAO;
import com.capgemini.retailermaintenance.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	@Override
	public boolean register(User user) {
		return dao.register(user);
	}

	@Override
	public User login(User credentials) {
		return dao.login(credentials);
	}

	@Override
	public boolean modifyPassword(String email, String password) {
		return dao.modifyPassword(email, password);
	}

}
