package com.infosys.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.jpademo.Beans.Employee;
import com.infosys.jpademo.dao.EmployeeDao;

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
		Employee e = employeeDao.addEmployee(new Employee("John2","Testing"));
		System.out.println(e.toString());
	}

}
