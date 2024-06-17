package com.infosys.jpademo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.jpademo.Beans.Employee;
import com.infosys.jpademo.dao.EmployeeDao;

import jakarta.persistence.criteria.CriteriaBuilder.Case;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {
    @Autowired
	EmployeeDao employeeDao;
    
	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to add employee");
		System.out.println("Enter 2 to search employee by employee id");
		System.out.println("Enter 3 to  eupdate employee");
		System.out.println("Enter 4 to remove employee");
		System.out.println("Enter 5 to get employee list");
		System.out.println("Enter choice");
		int ch = sc.nextInt();
		
		switch (ch) {
		case 1: {
			
			Employee e = employeeDao.addEmployee(new Employee("Mike","DevOps"));
			System.out.println(e.toString());
		}
		   break;
		case 2:
			{
			   employeeDao.findEmployee();	
			}
			
		break;	
		
		case 3:
		{
		   employeeDao.updateEmployeeDepartment();
		}
		
	break;	
   case 4:
		{
		   employeeDao.removeEmployee();
		}
		
	break;	
	
   case 5:
		{
		   employeeDao.findAllEmployees();;
		}
		
	break;	
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
		
	}

}
