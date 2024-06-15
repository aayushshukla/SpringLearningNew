package com.infosys.jpademo.dao;

import org.springframework.stereotype.Repository;

import com.infosys.jpademo.Beans.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

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

}
