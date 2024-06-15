package com.infosys.jpademo.Beans;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor

//@EqualsAndHashCode
@Entity   // Specifies that the class is an entity. This annotation is applied to theentity class.
@Table(name="jpa_employee")
public class Employee {
	@Id  // Specifies the primary key of an entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  @Getter @Setter int empId;
	@Column
	@Getter @Setter
	private  String empName;
	@Column(name="emp_dept")
	@Getter @Setter
	private String empDepartment;
	
	public Employee(String empName,String empDepartment)
	{
		this.empName=empName;
		this.empDepartment=empDepartment;
	}
}
