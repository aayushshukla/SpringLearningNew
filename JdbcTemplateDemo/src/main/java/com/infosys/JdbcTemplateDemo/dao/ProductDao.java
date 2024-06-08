package com.infosys.JdbcTemplateDemo.dao;

import java.util.List;

import com.infosys.JdbcTemplateDemo.beans.Product;

public interface ProductDao {
	
	public int addProduct(Product product);
	
	public int updateQuantity(int id);
	
	public int removeProduct(int id);
	
	public Product getProductInfo(int id);
	
	public List<Product> getProductList();

}
