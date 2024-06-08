package com.infosys.JdbcTemplateDemo.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.infosys.JdbcTemplateDemo.beans.Product;

@Component
public class ProductDaoService implements ProductDao {

	private JdbcTemplate jdbcTemplate;
	private String tableName="productinfo";
	
	
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		String query = "insert into productinfo values(?,?,?,?)";
		int res = jdbcTemplate.update(query,product.getProductId(),product.getProductName(),
				product.getProductQuantity(),product.getProductPrice());
		return res;
	}


	@Override
	public int updateQuantity(int id) {
		// TODO Auto-generated method stub
		String query="update productinfo set quantity =? where pid =?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter quantity to update");
		int quantity=sc.nextInt();
		int res = jdbcTemplate.update(query,quantity,id);
		return res;
		
	}
	
	@Override
	public int removeProduct(int id) {
		// TODO Auto-generated method stub
		String query="delete from "+tableName+" where pid =?";
		int res = jdbcTemplate.update(query,id);
		return res;
	}
	
	@Override
	public Product getProductInfo(int id) {
		// TODO Auto-generated method stub
		String query="select * from productinfo where pid =?";
		RowMapper<Product> mapper = new ProductMapper();
		//queryForObject(sql, rowmapper , object args) to fetch single object 
		Product p = jdbcTemplate.queryForObject(query,mapper,id);
		return p;
	}
	
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		String query="select * from productinfo";
		RowMapper<Product> mapper = new ProductMapper();
		//query=(sql, rowmapper) to fetch multiple object 
		List<Product> plist = jdbcTemplate.query(query,mapper);
		return plist;
	}
  
 
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


    @Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	




	



	
	
	

}
