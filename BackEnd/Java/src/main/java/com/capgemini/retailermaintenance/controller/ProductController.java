package com.capgemini.retailermaintenance.controller;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenance.service.ProductService;

@RestController
public class ProductController {
	
	@autowired
	ProductService service;

}
