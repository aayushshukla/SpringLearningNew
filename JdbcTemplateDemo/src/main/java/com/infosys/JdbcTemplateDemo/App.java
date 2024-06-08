package com.infosys.JdbcTemplateDemo;

import java.util.List;
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
        ProductDaoService ps =	context.getBean(ProductDaoService.class);
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
		 
		 Product p = new Product();
		 p.setProductId(2);
		 p.setProductName("Choco powder");
		 p.setProductQuantity(100);
		 p.setProductPrice(10);
		 int res =ps.addProduct(p);
		 System.out.println("Product added"+res);
		 break;
		}
		case 2:
			{
				
				System.out.println("Enter product id to update quantity");
				int pid = sc.nextInt();
			    int res= ps.updateQuantity(pid);
			    if (res!=0)
			    {
			    	System.out.println("Updation done successfully");
			    	System.out.println("Updation is"+res+"records");
			    }
			
			}
		break;
		
		case 3:
		{
			
			System.out.println("Enter product id to remove");
			int pid = sc.nextInt();
		    int res= ps.removeProduct(pid);
		    if (res!=0)
		    {
		    	System.out.println("product is removed successfully");
		    	
		    }
		    else
		    {
		    	System.err.println("Product removal failed");
		    }
		
		}
	break;
		case 4:
		{
			System.out.println("Enter product id to get info");
			int pid = sc.nextInt();
		 try {
		    Product p=	ps.getProductInfo(pid);
		    if(p!=null)
		    {
		    	System.out.println(p.toString());
		    	System.out.println("Product Name"+p.getProductName());
		    	System.out.println("Product Price"+p.getProductPrice());
		    }
		 }
		 catch(Exception e)
		 {
			 System.err.println(" Not able to find the product"+e.getMessage());
		 }
		}
		break;
		case 5:
		{
		   List<Product> plist=	ps.getProductList();
		   for(Product p :plist)
		   {
			   System.out.println(p.toString());
		   }
		}
        break;
		default:
			System.err.println("invalid option selected");
		}
    }
}
