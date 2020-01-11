package com.capgemini.retailermaintenance.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<Order> order;

}
