package com.capgemini.flipcart.factory;

import com.capgemini.flipcart.dao.ProductDAO;
import com.capgemini.flipcart.dao.ProductDAOImpl;
import com.capgemini.flipcart.service.ServiceDAO;
import com.capgemini.flipcart.service.ServiceDAOImpl;

public class ProductFactory {
	
	private ProductFactory()
	{
		
	}
	
	public static ProductDAO instanceOfProductDAOImpl()
	{
		ProductDAO dao = new ProductDAOImpl();
		return dao;
	}
	
	public static ServiceDAO instanceOfServiceDAOImpl()
	{
		ServiceDAO services = new ServiceDAOImpl();
		return services;
		} 
 
}
