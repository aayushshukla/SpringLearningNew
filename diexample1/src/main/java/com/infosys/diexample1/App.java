package com.infosys.diexample1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.diexample1.beans.Employee;
import com.infosys.diexample1.beans.Person;
import com.infosys.diexample1.config.Config;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Employee emp = context.getBean(Employee.class);
        emp.showEmpDetails();
       
        Person p  = context.getBean(Person.class);
        p.personVehicleDetails();
    }
}
