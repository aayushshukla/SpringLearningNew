package com.infosys.springbootmvcdemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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

	@Override
	public List<Trainer> showAllTrainers() {
		// TODO Auto-generated method stub
		List<Trainer> tlist=  trainerRepo.findAll();
		return tlist;
	}

	@Override
	public String removeTrainer(int trainerId) {
		// TODO Auto-generated method stub
	   Trainer trainer =	trainerRepo.findById(trainerId).get();
	   String msg=null;
	   if(trainer!=null)
	   {
		   trainerRepo.delete(trainer);
		   msg="Trainer removed";
	   }
		return msg;
	}
}
