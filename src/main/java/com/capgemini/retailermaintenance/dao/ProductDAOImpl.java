package com.capgemini.retailermaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenance.dto.Product;
import com.capgemini.retailermaintenance.exception.ProductException;


@Repository
public class ProductDAOImpl implements ProductDAO {
	

	@PersistenceUnit
	EntityManagerFactory factory;

	
	public boolean addProduct(Product product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ProductException("product with the same id already exists");
			
		}
	}

	


	public Product searchProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		Product product = manager.find(Product.class, id);
		return product;
	}



	

}
