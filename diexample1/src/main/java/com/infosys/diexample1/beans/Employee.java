package com.infosys.diexample1.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	int empId;
	String empName;
	@Autowired // it marks on field , setter method , constructor is used to auto wire the bean
	// that is injecting at runtime by Spring Dependency injection mechanism.

	Address empAddress; // has - a relationship
	// creating references of address class 
	// by using @autowire we are injecting dependency of address .
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public void showEmpDetails()
	{
		System.out.println(" Emp Name is ="+this.getEmpName());
		System.out.println("Emp Id is ="+this.getEmpId());
		empAddress.getAddressDetails();
	}

}
