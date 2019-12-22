package com.capgemini.flipcart.service;

import java.util.List;

import com.capgemini.flipcart.bean.ProductBean;

public interface ServiceDAO {
	public List<ProductBean> getAllProduct();
	public ProductBean search(int productId,String productName);
	public boolean buyProduct(int productId,long cardno,int cvv);


}
