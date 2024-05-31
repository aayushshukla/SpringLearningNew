package com.infosys.diexample1.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	
	String name;
	Vehicle personVehicle;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vehicle getPersonVehicle() {
		return personVehicle;
	}
	
	@Autowired(required = false)
	// when we have ,multiple beans of same type 
	// we can use @Qualifier(beanName)
	public void setPersonVehicle(@Qualifier("audi") Vehicle personVehicle) {
		this.personVehicle = personVehicle;
	}
	
	public void personVehicleDetails()
	{
		System.out.println(" Name is "+this.getName());
		this.getPersonVehicle().showVehicleDetails();
	}
	
	

}
