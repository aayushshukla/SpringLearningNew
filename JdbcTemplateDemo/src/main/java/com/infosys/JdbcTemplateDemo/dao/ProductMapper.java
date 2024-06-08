package com.infosys.JdbcTemplateDemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.infosys.JdbcTemplateDemo.beans.Product;

public class ProductMapper  implements RowMapper<Product>{

	// map each row of data in the ResultSet
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		 Product product = new Product();
		// rs.getDatatype(columnindex)  index starts from 1
		// rs.getDatatype(columnlabel)
		  product.setProductId(rs.getInt(1));
		  product.setProductName(rs.getString(2));
		  product.setProductQuantity(rs.getInt("quantity"));
		  product.setProductPrice(rs.getInt(4));
		 return product;
	}

}
