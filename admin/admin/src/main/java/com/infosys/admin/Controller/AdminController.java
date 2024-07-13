package com.infosys.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.admin.Model.AdminResponse;
import com.infosys.admin.Model.Course;
import com.infosys.admin.proxy.AdminProxy;

@RestController
@RequestMapping("/adminservice")
public class AdminController {
	
	@Autowired
	AdminProxy adminProxy;
	
	@GetMapping("/admin")
	public ResponseEntity<AdminResponse> adminHome()
	{
		AdminResponse response = new AdminResponse();
		response.setHttpStatusCode(HttpStatus.OK);
		response.setHttpMessage("Hello From Admin Service");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/getcourselist")
	public List<Course> getCourseList()
	{
		 return adminProxy.getAllCourses();
	}
	
	@GetMapping("/getcoursebyid")
	public Course getCourseById(@RequestParam int courseId)
	{
		return adminProxy.searchCourseById(courseId);
	}

}
