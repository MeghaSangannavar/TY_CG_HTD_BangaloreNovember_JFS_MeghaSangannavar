package com.capgemini.retailermaintenance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User {
	
	@Id
	@Column(unique = true,nullable = false)
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;

}
