package com.infosys.JdbcTemplateDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.JdbcTemplateDemo.beans.Product;

@Component
public class ProductDaoService implements ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		String query = "insert into productinfo values(?,?,?,?)";
		int res = jdbcTemplate.update(query,product.getProductId(),product.getProductName(),
				product.getProductQuantity(),product.getProductPrice());
		return res;
	}


 
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


    @Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	

}
