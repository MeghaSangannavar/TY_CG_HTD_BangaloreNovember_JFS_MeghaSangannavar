package com.capgemini.flipcart.dao;

import java.util.List;

import com.capgemini.flipcart.bean.ProductBean;

public interface ProductDAO {
	
	public List<ProductBean> getAllProduct();
	public ProductBean search(int productId,String productName);
	public boolean buyProduct(int productId,long cardno,int cvv);
	
	
	

}
