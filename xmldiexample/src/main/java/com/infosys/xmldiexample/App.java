package com.infosys.xmldiexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.xmldiexample.beans.Batches;
import com.infosys.xmldiexample.beans.Trainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
      Trainer trainer1 = context.getBean(Trainer.class);
      System.out.println(trainer1.getTrainerName());
      System.out.println(trainer1.getTrainerId());
      
      //Batches batch10 = context.getBean(Batches.class);
      Batches batch10 = (Batches) context.getBean("batch2");
      batch10.showBatchDetails();
      
      Batches batch1 = (Batches) context.getBean("batch1");
      batch1.showBatchDetails();
    }
}
