package com.capgemini.flipcart.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.flipcart.bean.ProductBean;

public class ProductDAOImpl implements ProductDAO {
	FileReader reader;
	Properties prop;
	ProductBean bean;
	
	public ProductDAOImpl()
	{
		try {
			reader = new FileReader("db.properties");
			prop   = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
						e.printStackTrace();
		}
		
	}
	

	@Override
	public List<ProductBean> getAllProduct() {
		List<ProductBean> list = new ArrayList<ProductBean>();
		
			try( Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(prop.getProperty("getAllProduct")))
			
			{
				while(rs.next()) {
					bean = new ProductBean();
					bean.setProductId(rs.getInt(3));
					bean.setProductName(rs.getString(1));
					bean.setCost(rs.getDouble(3));
					bean.setCategory(rs.getString(4));
					bean.setDescription(rs.getString(2));
					bean.setNo_of_product(rs.getInt(6));
					list.add(bean);
					
					
				}
				
				return list;
			}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public ProductBean search( int productId,String productName) {
		try( Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchQuery")))
		{
			pstmt.setInt(1, productId);
			pstmt.setString(2, productName);		
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				bean.setProductId(rs.getInt(1));
				bean.setProductName(rs.getString(2));
				bean.setCost(rs.getDouble(3));
				bean.setCategory(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setNo_of_product(rs.getInt(6));
			}
			return bean;
      }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}

	@Override
	public boolean buyProduct(int productId, long cardno, int cvv) {
		try( Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement("buyQuery"))
		{
			pstmt.setInt(1, bean.getProductId());
			pstmt.setLong(2, bean.getCardno());
			pstmt.setInt(3, bean.getCvv());
			
			int count = pstmt.executeUpdate();
			if(count > 0)
			{
				pstmt.setInt(1, bean.getProductId());
				pstmt.setLong(2, bean.getCardno());
				pstmt.setInt(3, bean.getCvv());
			}
			
			return true;
			
		}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	
	return false;
}
}
