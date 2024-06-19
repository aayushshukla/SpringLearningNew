package com.example.JPADemo2;

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
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}

}
