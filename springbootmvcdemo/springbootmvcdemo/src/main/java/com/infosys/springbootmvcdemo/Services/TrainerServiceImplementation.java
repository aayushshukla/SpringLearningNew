package com.infosys.springbootmvcdemo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.springbootmvcdemo.DAO.TrainerRepo;
import com.infosys.springbootmvcdemo.Model.Trainer;

@Service
public class TrainerServiceImplementation implements TrainerService {
	
	@Autowired
	TrainerRepo trainerRepo;

	@Override
	public void trainerSignUp(Trainer trainer) {
		// TODO Auto-generated method stub
	try {	
	    Trainer t =	trainerRepo.save(trainer);
	    if(t!=null)
	    {
	    	System.out.println("SignUp successfull");
	    }
	}
	catch (Exception e) {
		 System.err.println("SignUp Failed"+e);
	   }
	}
}
