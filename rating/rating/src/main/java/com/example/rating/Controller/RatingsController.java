package com.example.rating.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rating")
public class RatingsController {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/home")
	public String home()
	{
		System.err.println(environment.getProperty("local.server.port"));
		 return "Please rate our services";
	}

}
