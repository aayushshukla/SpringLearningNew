package com.infosys.restapidemo.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.restapidemo.DAO.CourseRepository;
import com.infosys.restapidemo.Exception.CourseException;
import com.infosys.restapidemo.Models.Course;
import com.infosys.restapidemo.Models.CourseResponse;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // (@Controller + @ResponseBody)
public class MyCourseController {
	@Autowired
	CourseRepository courseRepository;

	@GetMapping("/home")
	public String myHome()
	{
		return "Welcome In Learning With Aayush";
	}
	
	@GetMapping("/welcome")
	public CourseResponse myWelcome()
	{
		CourseResponse  response = new CourseResponse();
		response.setStatusCode(200);
		response.setStatusMsg("Welcome in learning spring boot rest api creation");
		return response;
		
	}
	
	// Marks a property, method parameter or method return type for validation cascading. 
		@PostMapping("/addcourse")
		public CourseResponse addCourse(@Valid @RequestBody Course course)
		{
			courseRepository.save(course);
			CourseResponse  response = new CourseResponse();
			response.setStatusCode(200);
			response.setStatusMsg("Course Added Successfully");
			response.setResponseDate(java.time.LocalDate.now());
			return response;
		    
		}
	
	@GetMapping("/")
	// @RequestHeader("Sec-Ch-Ua-Platform") String platform
	public CourseResponse homePage(@RequestHeader("User-Agent") String headeragent
		)
	{
		System.out.println(headeragent);
		
		log.info(String.format("Header user agent making request %s ",headeragent));
		//log.info(String.format("Header platform  %s ",platform));
		CourseResponse  response = new CourseResponse();
		response.setStatusCode(200);
		response.setStatusMsg("Welcome User");
		response.setResponseDate(java.time.LocalDate.now());
		return response;
		
	}
	
	
	@PostMapping("/newcourse")
	public ResponseEntity<CourseResponse> addNewCourse(@Valid @RequestBody Course course)
	{
		courseRepository.save(course);
		CourseResponse  response = new CourseResponse();
		response.setStatusCode(200);
		response.setStatusMsg("New Coure Added Successfully");
		response.setResponseDate(java.time.LocalDate.now());
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("MyHeader","Rest demo app")
				 .body(response);
				 
	}
	@GetMapping("/searchCourse")
	public  Course searchCourseById(@RequestParam int courseId)
	{
		return courseRepository.findById(courseId).orElseThrow(()-> new CourseException(courseId));
	}
	 
}
