package com.capgemini.retailermaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenance.dto.User;
import com.capgemini.retailermaintenance.exception.UserException;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean register(User user) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new UserException("User with same email already exists");
			
		}
	}

	@Override
	public User login(User credentials) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from User where email=:email";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("email", credentials.getEmail());
		try {
			User account = query.getSingleResult();
			if (account.getPassword().equals(credentials.getPassword())) {
				return account;
			} else {
				System.out.println("here above valid");
				return null;
			}
		} 
		catch (Exception e) {
			throw new UserException("Account does not exist");
			
		}
	}

	@Override
	public boolean modifyPassword(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		User user = manager.find(User.class, email);
		user.setPassword(password);
		transaction.commit();
		return true;
	}
	
	

	}


