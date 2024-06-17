package com.infosys.jpademo.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.infosys.jpademo.Beans.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDao {
	 
	EntityManagerFactory emf;
	

   @PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

  /*
   * entity manager is used to allow application to manage and search for entities in
   * the relation database.It manages the lifecycle of entity instances.
   * An entity managerobject  manages a set of entities that are defined by persistence
   * unit
   * 4 States :   new or transient  2. managed / persistent  3. detached 4.remove
   */

	public Employee addEmployee(Employee e)
	{
		// creating entity manager object
		// factory design pattern
		EntityManager em = emf.createEntityManager();
		//begin traction to make changes
		em.getTransaction().begin();
		// changing state from new to persist/managed
		em.persist(e); // to save object to entity
		// commit the current resource transction 
		em.getTransaction().commit();
		return e;
	}
	
	public void findEmployee()
	{
        EntityManager em =	emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id");
        int empid = sc.nextInt();
        em.getTransaction().begin();
       
        Employee  e =  em.find(Employee.class,empid);
        if(e!=null)
         {
        	 System.out.println("Employee name is "+e.getEmpName());
        	 System.out.println("Rmployee dept is"+e.getEmpDepartment());
       
          }
        else
	        {
	          System.err.println(" Invalid employee id employee not found");	
	        	
	        }
        em.getTransaction().commit();
        em.close();
		
	}
	
	public void updateEmployeeDepartment()
	{
		 EntityManager em =	emf.createEntityManager();
	     Scanner sc = new Scanner(System.in);
	     System.out.println("Enter employee id to update department");
	     int empid = sc.nextInt();
	     System.out.println("Enter new department");
	     String newDept= sc.next();
	     em.getTransaction().begin();
	     Employee  e =  em.find(Employee.class,empid);
	     if(e!=null)
	      {
	         System.out.println("Employee old department"+e.getEmpDepartment());
	         e.setEmpDepartment(newDept);
	         
	      }
	     else
	     {
	    	 System.err.println(" Invalid employee id employee not found");
	     }
	     em.getTransaction().commit();
	        em.close(); 
		
	}
	
	public void removeEmployee()
	{
		 EntityManager em =	emf.createEntityManager();
	     Scanner sc = new Scanner(System.in);
	     System.out.println("Enter employee id to remove");
	     int empid = sc.nextInt();
	     em.getTransaction().begin();
	     Employee  e =  em.find(Employee.class,empid);
	     if(e!=null)
	      {
	        em.remove(e);
	        System.err.println("Rmployee removed");
	         
	      }
	     else
	     {
	    	 System.err.println(" Invalid employee id employee not found");
	     }
	     em.getTransaction().commit();
	     em.close(); 
	}
	
	public void findAllEmployees()
	{
		String query ="SELECT e from Employee e";
		 EntityManager em =	emf.createEntityManager();
	     TypedQuery<Employee> empList= 	 em.createQuery(query,Employee.class);
		 List<Employee>  elist= empList.getResultList();
		 for(Employee e : elist)
		 {
			 System.out.println("\t"+e.getEmpId()+"\t"+e.getEmpName()+"\t"+e.getEmpDepartment());
			
		 }
		 em.close();
	}

}
