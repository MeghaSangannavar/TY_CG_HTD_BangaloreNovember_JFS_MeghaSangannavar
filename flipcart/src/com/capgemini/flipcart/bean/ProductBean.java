package com.capgemini.flipcart.bean;

import lombok.Data;

@Data
public class ProductBean {
	
	private int productId;
	private String productName;
	private double cost;
	private String  category;
	private String description;
	private int no_of_product;
	private long cardno;
	private int cvv;

}
