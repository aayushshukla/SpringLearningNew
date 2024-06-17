package com.infosys.jpademo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.jpademo.Beans.Employee;

@Repository
public interface EmployeeRepo {
	
	public List<Employee> findAll();

}
