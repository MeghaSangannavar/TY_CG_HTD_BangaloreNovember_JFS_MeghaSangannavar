package com.capgemini.retailermaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenance.dto.Order;
import com.capgemini.retailermaintenance.exception.OrderException;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addOder(Order order) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(order);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new OrderException("Oder with same id already exist");
		}
	}

	@Override
	public Order searchOrder(int oid) {
		EntityManager manager = factory.createEntityManager();
		Order order = manager.find(Order.class, oid);
		return order;
	}

}
