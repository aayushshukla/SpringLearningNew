package com.infosys.restapidemo.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("courseservice")
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
	
	@GetMapping("/allcourses")
	public List<Course> getAllCourses()
	{
		// ;
		 //List<Course> courseList =   courseRepository.findAll();
		List<Course> courseList = new ArrayList<Course>();
		courseRepository.findAll().forEach(course -> courseList.add(course) );
	   
	    return courseList;
	}
	
	@DeleteMapping("/removecourse")
	public ResponseEntity<CourseResponse>  deleteCourse(RequestEntity<Course> requestEntity)
	 
	{
	   HttpHeaders headers= requestEntity.getHeaders();
	   headers.forEach((key,value)->{
		   System.err.println("\t"+key+"=->"+value+"\n");
	   });
		Course  mycourse = requestEntity.getBody();
		log.info(" "+mycourse.getCourseId());
		courseRepository.deleteById(mycourse.getCourseId());
		CourseResponse response = new CourseResponse();
		response.setStatusCode(200);
		response.setStatusMsg("Course removed successfully");
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@PatchMapping("updatecourse")
	public ResponseEntity<CourseResponse>  updateCourse(@RequestBody Course newcourse)
	{
		CourseResponse response = new CourseResponse();
		Optional<Course>  oldcourse =  courseRepository.findById(newcourse.getCourseId());
		if(oldcourse.isPresent())
		{
			oldcourse.get().setCourseName(newcourse.getCourseName());
			oldcourse.get().setDuration(newcourse.getDuration());
			courseRepository.save(oldcourse.get());
		}
		else
		{
			response.setStatusCode(400);
			response.setStatusMsg("Course Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			
		}
		
		response.setStatusCode(200);
		response.setStatusMsg("New Course Information Is Updated");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
