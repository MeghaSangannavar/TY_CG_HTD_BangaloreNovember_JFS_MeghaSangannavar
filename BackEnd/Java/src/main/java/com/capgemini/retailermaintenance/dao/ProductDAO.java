package com.capgemini.retailermaintenance.dao;

import com.capgemini.retailermaintenance.dto.Product;
import com.capgemini.retailermaintenance.dto.User;

public interface ProductDAO {
	
    public boolean addProduct(Product product);
	
	
	
	public Product searchProduct(int id);

}
