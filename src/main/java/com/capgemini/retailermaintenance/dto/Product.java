package com.capgemini.retailermaintenance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "product_info")
public class Product {
	
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue
	private int pid;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private int quantity;
	
	@Column
	private String details;
	
	
	

}
