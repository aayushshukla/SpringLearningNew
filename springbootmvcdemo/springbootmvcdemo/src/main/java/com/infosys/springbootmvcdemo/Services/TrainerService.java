package com.infosys.springbootmvcdemo.Services;

import java.util.List;

import com.infosys.springbootmvcdemo.Model.Trainer;

public interface TrainerService {
	
	public void trainerSignUp(Trainer trainer);
    List<Trainer> showAllTrainers();
    String  removeTrainer(int trainerId);
    void updateTrainerData(Trainer trainer);
}
