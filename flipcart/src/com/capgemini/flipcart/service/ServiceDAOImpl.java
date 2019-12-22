package com.capgemini.flipcart.service;

import java.util.List;

import com.capgemini.flipcart.bean.ProductBean;
import com.capgemini.flipcart.dao.ProductDAO;
import com.capgemini.flipcart.factory.ProductFactory;

public class ServiceDAOImpl implements ServiceDAO {
	
	ProductDAO dao = ProductFactory.instanceOfProductDAOImpl();

	@Override
	public List<ProductBean> getAllProduct() {
		
		return dao.getAllProduct();
	}

	@Override
	public ProductBean search(int productId,String productName) {
		
		return dao.search(productId,productName);
	}

	@Override
	public boolean buyProduct(int productId, long cardno, int cvv) {
		return dao.buyProduct(productId, cardno, cvv);	
				}

}
