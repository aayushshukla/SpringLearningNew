package com.infosys.JdbcTemplateDemo;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.infosys.JdbcTemplateDemo.beans.Product;
import com.infosys.JdbcTemplateDemo.config.Config;
import com.infosys.JdbcTemplateDemo.dao.ProductDao;
import com.infosys.JdbcTemplateDemo.dao.ProductDaoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		/*
		 * JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * String query= "insert into productinfo values (?,?,?,?)"; int res =
		 * template.update(query,1,"Bread",10,50);
		 * System.out.println("Product added"+res);
		 */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to add product");
        System.out.println("Enter 2 to update product");
        System.out.println("Enter 3 to remove product");
        System.out.println("Enter 4 to get product");
        System.out.println("Enter 5 to get product list");
        
        System.out.println("Enter your operation");
        int ch =sc.nextInt();
        switch (ch) {
		case 1: {
		 ProductDaoService ps =	context.getBean(ProductDaoService.class);
		 Product p = new Product();
		 p.setProductId(2);
		 p.setProductName("Choco powder");
		 p.setProductQuantity(100);
		 p.setProductPrice(10);
		 int res =ps.addProduct(p);
		 System.out.println("Product added"+res);
		 break;
		}
		default:
			System.err.println("invalid option selected");
		}
    }
}
