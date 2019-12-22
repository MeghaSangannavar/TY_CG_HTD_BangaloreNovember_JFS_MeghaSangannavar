package com.capgemini.flipcart.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.flipcart.bean.ProductBean;
import com.capgemini.flipcart.factory.ProductFactory;
import com.capgemini.flipcart.service.ServiceDAO;

public class FlipCartApp {
	public static void main(String[] args) {

		ProductBean bean = new ProductBean();
		Scanner sc = new Scanner(System.in);
		ServiceDAO services = ProductFactory.instanceOfServiceDAOImpl();
		System.out.println("1.Show All Product\n2.Serach for Product\n3.Buy\n4.Home");
		System.out.println("enter your choice");
		int ch = sc.nextInt();
		switch(ch)
		{
		case 1:List<ProductBean> list = services.getAllProduct();
		System.out.println(list);


		case 2:System.out.println("Enter ProductName");
		bean.setProductName(sc.next());
		ProductBean b1= services.search(bean.getProductId(),bean.getProductName());

		if( b1 != null)
		{
			System.out.println("ProductId is " +b1.getProductId());
			System.out.println("product name is " +b1.getProductName());
			System.out.println("product cost is " +b1.getCost());
			System.out.println("product category is " +b1.getCategory());
			System.out.println("product description is " +b1.getDescription());
			System.out.println("number of product is equal to " +b1.getNo_of_product());

		}
		else
		{
			System.out.println("Unable to get the Product Details");
		}

		break;


		case 3:System.out.println("Enter ProductId");
		       bean.setProductId(Integer.parseInt(sc.next()));
		       System.out.println("Enter 16 digit cardnumber");
		       bean.setCardno(Long.parseLong(sc.next()));
		       System.out.println("Enter cvv");
		       bean.setCvv(Integer.parseInt(sc.next()));
		       
		       boolean b2 = services.buyProduct(bean.getProductId(), bean.getCardno(),bean.getCvv());
		    
		    		   if(b2)
		    		   {
		    			   System.out.println("product bought");
		    		   }else {
		    			   System.out.println("unable to buy");
		    		   }
		       break;


		case 4:FlipCartApp.main(null);

		}
	}

}
