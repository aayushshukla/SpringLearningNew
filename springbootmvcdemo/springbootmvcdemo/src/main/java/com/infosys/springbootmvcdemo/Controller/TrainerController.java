package com.infosys.springbootmvcdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.springbootmvcdemo.Model.Trainer;
import com.infosys.springbootmvcdemo.Services.TrainerServiceImplementation;

@Controller // Indicates that an annotated class is a "Controller
public class TrainerController {
	
	@Autowired
	TrainerServiceImplementation trainerServiceImplementation;
   
	@RequestMapping("/home")
	//annotion for mapping request on the methods in request handling  classes 
	// with flexible method signaturs
	// homePage method will be executed if user is going to make request to home url
	//@GetMapping("/home")
	@ResponseBody
	// Annotation that indicates a method return value should be bound to the webresponse body.
	//Supported for annotated handler methods.
	
	public String homePage()
	{
		//System.out.println("Hello home page");
		return "welcome to home";
	}
	
	@GetMapping("/welcome")
	public String welcomePage()
	{
		//System.out.println("Hello home page");
		return "home";
	}
	
	@GetMapping("/signup")
	public String signUpPage()
	{
		//System.out.println("Hello home page");
		return "SignUp";
	}
	
	@PostMapping("/sigupdetail")
	public ModelAndView signupInfo(Trainer trainer)
	{
		 System.out.println("Trainer Name"+trainer.getTrainerName());
		 System.out.println("Trainer Email"+trainer.getTrainerEmail());
		 System.out.println("Trainer Password"+trainer.getTrainerPassword());
		 System.out.println("Trainer Experiece"+trainer.getExp());
		 trainerServiceImplementation.trainerSignUp(trainer);
		 // sending data from controller to jsp
		 // sending data "signup successfull" to SignUp.jsp
		 
		 ModelAndView mv = new ModelAndView("/SignUp");
		 mv.addObject("message", "SignUp Successfull");
		 return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage()
	{
		
	   List<Trainer>	 tlist =trainerServiceImplementation.showAllTrainers();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/TrainerDetails");
		mv.addObject("trainerList",tlist);
		return mv;
	}
	
	@GetMapping("/deleteTrainer")
	//@RequestMapping(value="/deleteTrainer",method = RequestMethod.GET)
	// Annotation which indicates that a method parameter should be bound to a webrequest parameter. 
	public ModelAndView deleteTrainer(@RequestParam int trainerid)
	{
	  String msg =	trainerServiceImplementation.removeTrainer(trainerid);
	  ModelAndView mv = new ModelAndView();
	  if(msg!=null)
	  {
		  List<Trainer>	 tlist =trainerServiceImplementation.showAllTrainers();
		  mv.setViewName("/TrainerDetails");
		  mv.addObject("trainerList",tlist);
	  }
	  else
	  {
		  mv.setViewName("/Delete");
	  }
	 return mv;
	}
	 
	@GetMapping("/updateFormPage")
	public ModelAndView updatePage(@RequestParam  int trainerid )
	{
		ModelAndView mv = new ModelAndView("/UpdateForm");
		mv.addObject("tid", trainerid);
		return mv;
	}
	@PostMapping("/updateInfo")
	public void updateTrainerInfo(Trainer trainer)
	{
		trainerServiceImplementation.updateTrainerData(trainer);
	}
}
