package com.infosys.diexample1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infosys.diexample1.beans.Address;
import com.infosys.diexample1.beans.Employee;
import com.infosys.diexample1.beans.Person;
import com.infosys.diexample1.beans.Vehicle;

@Configuration
public class Config {
	
	@Bean
	Address getAddress()
	{
		Address add = new Address("New Delhi",2344);
		return add;
	}
	
	@Bean
	Employee getEmployee()
	{
		Employee emp = new Employee();
		emp.setEmpId(101);
		emp.setEmpName("Rohan");
		return emp;
	}
	
	@Bean(name="audi")
	Vehicle getVehicleData()
	{
		Vehicle audi = new Vehicle();
		audi.setModelName("Audi");
		audi.setMileage(7.45);
		return audi;
	}
	
	@Bean(name = "tata")
	Vehicle getVehicleData1()
	{
		Vehicle tata = new Vehicle();
		tata.setModelName("Tata");
		tata.setMileage(7.45);
		return tata;
	}
	@Bean
	Person getPerson()
	{
		Person obj = new Person();
		obj.setName("Ruturaj");
		return obj;
	}
	

}
