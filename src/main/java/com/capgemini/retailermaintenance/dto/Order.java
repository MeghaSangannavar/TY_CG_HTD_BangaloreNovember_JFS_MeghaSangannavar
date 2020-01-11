package com.capgemini.retailermaintenance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name =  "order_info")
public class Order {
	@Id
	@Column(unique = true,nullable = false)
	@GeneratedValue
	private int oid;
	
	

}
