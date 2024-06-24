package com.example.JPADemo2.Services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPADemo2.DAO.TrainerRepo;
import com.example.JPADemo2.Entities.Trainer;

@Service
public class TrainerService implements TrainerServiceInterface {
	@Autowired
	TrainerRepo trainerRepo;
	
	@Override
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
	
	@Override
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
 // update operation
	@Override
	public Trainer updateTrainerEmail(Trainer newtrainer,int id) {
		// TODO Auto-generated method stub
		
	    Trainer oldtrainerDetails =	trainerRepo.findById(id).get();
	    if(Objects.nonNull(oldtrainerDetails.getTrainerName()))
	     {
	    	oldtrainerDetails.setEmail(newtrainer.getEmail());
	     }
		return trainerRepo.save(oldtrainerDetails);
	}
// find all the trainers
	@Override
	public List<Trainer> findAllTrainers() {
		// TODO Auto-generated method stub
	     List<Trainer> trainerList 	=   trainerRepo.findAll();
		return trainerList;
	}
// remove trainer on basis of id 
	@Override
	public void removeTrainer(int id) {
		// TODO Auto-generated method stub
	 try {	
		//trainerRepo.deleteById(id); delete on basis of id 
		 Trainer t = trainerRepo.findById(id).get();
		 trainerRepo.delete(t);
		System.out.println("Trainer removed ");
	     }
	 catch(Exception e)
	 {
		 System.err.println(" Can not delete as Id is not found ");
	 }
	 
		
	}
	
	public void findByEmail(String email)
	{
	  List<Trainer>	    tlist     =  trainerRepo.findByEmail(email);
	  for(Trainer t : tlist)
	  {
		  System.out.println(t.getTrainerName()+"\t"+t.getTrainerId()+"\t"+t.getEmail());
	  }
	}
	
	public void findByPattern(String pattern)
	{
	  List<Trainer>	    tlist     =  trainerRepo.findByNamePattern(pattern);
	  for(Trainer t : tlist)
	  {
		  System.out.println(t.getTrainerName()+"\t"+t.getTrainerId()+"\t"+t.getEmail());
	  }
	}
	
	public void findByIdAndName(int id ,String trainerName)
	{
		Trainer t=   trainerRepo.findTrainerDetails(id, trainerName);
		System.out.println(t.toString());
		System.out.println(t.getEmail());
	}
	public void findAllTrainers1() {
		// TODO Auto-generated method stub
	     List<Trainer> trainerList 	=   trainerRepo.findAllTrainerInfo();
		 for(Trainer t : trainerList)
		 {
			 System.out.println(t.getTrainerName());
		 }
	}

}
