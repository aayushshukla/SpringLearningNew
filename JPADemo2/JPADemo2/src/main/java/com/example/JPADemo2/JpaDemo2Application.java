package com.example.JPADemo2;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JPADemo2.Entities.Trainer;
import com.example.JPADemo2.Services.TrainerService;

@SpringBootApplication
public class JpaDemo2Application implements CommandLineRunner {
    @Autowired
	TrainerService trainerService;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to add new trainer");
		System.out.println("Enter 2 to find trainer");
		System.out.println("Enter 3 to update trainer detail");
		System.out.println("Enter 4 to fetch all trainer details");
		System.out.println("Enter 5 to remove  trainer ");
		System.out.println("Enter 6 to fetch on basis of  trainer email ");
		System.out.println("Enter  7 to fetch on basis of  trainer name patter ");
		System.out.println("Enter  8 to fetch on basis of  trainer name and id ");
		System.out.println("Enter 9 to fetch all trainer details using native query");
		System.out.println("Enter choice");
		int ch= sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("enter trainer name");
			String tname= sc.next();
			System.out.println("enter trainer email");
			String temail= sc.next();
			
			Trainer  trainer = new Trainer();
			trainer.setTrainerName(tname);
			trainer.setEmail(temail);
			trainerService.addNewTrainer(trainer);
			
		}
		break;
		
		case 2:
		{
			System.out.println("enter trainer id");
			int trainerId=sc.nextInt();
			
		   Trainer trainer =trainerService.findTrainerById(trainerId);
		   if (trainer!=null)
		   {
			   System.out.println(trainer.getTrainerName()+"\t"+trainer.getEmail());
		   }
		   else
		   {
			   System.out.println("No trainer found");
		   }
		}
		
		break;
		
		case 3:
		{
			System.out.println("enter trainer id");
			int trainerId=sc.nextInt();
			System.out.println("enter trainer new email");
			String trainernewemail=sc.next();
			
			Trainer  newTrainer  = new Trainer();
			newTrainer.setTrainerId(trainerId);
			newTrainer.setEmail(trainernewemail);
		    Trainer obj = trainerService.updateTrainerEmail(newTrainer, trainerId);
		    if(obj==null)
		    {
		    	System.err.println("Updation failed");
		    }
		    else
		    {
		    	System.out.println("Updation done successfully");
		    }
			
		  
		}
		break;
		case 4:
		{
			String data=" ";
		   List<Trainer> tList=	trainerService.findAllTrainers();
		   for(Trainer trainer : tList)
		   {
			   data = data +trainer.getTrainerId() +"\t"+ trainer.getTrainerName()+"\t"+ trainer.getEmail()+"\n";
		   }
		   
		   System.err.println(data);
		}
		break;
		case 5:
		{
			System.out.println("enter trainer id");
			int trainerId=sc.nextInt();
			trainerService.removeTrainer(trainerId);
		}
		  break;
		  
		case 6:
		{
			System.out.println("enter trainer email");
			String trainerEmail=sc.next();
			trainerService.findByEmail(trainerEmail);
		}
		  break;
		case 7:
		{
			System.out.println("enter trainer name ");
			String trainerNamePattern=sc.next();
			trainerService.findByPattern(trainerNamePattern);
		}
		  break;
		  
		case 8:
		{
			System.out.println("enter trainer id");
			int trainerId=sc.nextInt();
			System.out.println("enter trainer name ");
			String trainerName=sc.next();
			trainerService.findByIdAndName(trainerId, trainerName);
		}
		
		
		  break;
		  
		case 9:
		{
			
			trainerService.findAllTrainers1();
		}
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}

}
