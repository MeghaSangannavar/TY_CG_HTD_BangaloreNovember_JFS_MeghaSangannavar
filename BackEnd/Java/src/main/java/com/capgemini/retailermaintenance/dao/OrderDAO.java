package com.capgemini.retailermaintenance.dao;

import com.capgemini.retailermaintenance.dto.Order;

public interface OrderDAO {
	
	public boolean addOder(Order order);
	 public Order searchOrder(int oid);

}
