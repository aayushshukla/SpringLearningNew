package com.example.JPADemo2.Services;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPADemo2.DAO.TrainerRepo;
import com.example.JPADemo2.Entities.Trainer;

@Service
public class TrainerService  {
	@Autowired
	TrainerRepo trainerRepo;
	
	public void addNewTrainer(Trainer trainer)
	 {
	   try {
	   	trainerRepo.save(trainer);
	   	System.out.println("New Trainer Info Added Successfully");
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   System.err.println("Trainer object failed to save it is null"+e);
	    }
	 }
	
	public Trainer findTrainerById(int tid)
	{
		Trainer trainer=null;
	     try {
		  Optional<Trainer>   otrainer=	  trainerRepo.findById(tid);
		   trainer = otrainer.get();
		  
	     }
	     catch (Exception e) {
	 		// TODO: handle exception
	 		   System.err.println("Trainer not found"+e);
	 	    }
	     
	     return trainer;
	   
	}

}
