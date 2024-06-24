package com.example.JPADemo2.Services;

import java.util.List;

import com.example.JPADemo2.Entities.Trainer;

public interface TrainerServiceInterface {
	
	 void addNewTrainer(Trainer trainer);
	 public Trainer findTrainerById(int tid);
	 
	  Trainer updateTrainerEmail(Trainer trainer,int id);
	  
	 public List<Trainer>  findAllTrainers();
	 
	 public  void removeTrainer(int id);

}
