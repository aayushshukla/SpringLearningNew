package com.infosys.admin.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.infosys.admin.Model.Course;



//@FeignClient(name ="give service name",url="serviceconsumedurl",path="contextpath")
@FeignClient(url="http://localhost:9000/courseservice/", value="courseservice")
//@FeignClient(name="Restapidemo-Service",url="/courseservice/")
public interface AdminProxy {

	 @GetMapping("/allcourses")
	 List<Course> getAllCourses();
	 
	 @GetMapping("/searchCourse")
	 public  Course searchCourseById(@RequestParam int courseId);
}
