package com.infosys.restapidemo.Exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infosys.restapidemo.Models.CourseResponse;

//Types that carry this annotation are treated as controller advices where @ExceptionHandler methods assume
@RestControllerAdvice(annotations = RestController.class)
@Order(1) // order defines the sort order for annotated component 
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{
	// this method handles if request data format is incorrect 
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		
		CourseResponse response = new CourseResponse();
		response.setStatusCode(400);
		response.setStatusMsg(ex.getBindingResult().toString());
		return new ResponseEntity (response,HttpStatus.BAD_REQUEST);
		
	}
	

   
	@ExceptionHandler  
	//Annotation for handling exceptions in specific handler classes and/or handler methods. 
	public ResponseEntity<CourseResponse>  exceptionHandler(CourseException courseException)
	{
		CourseResponse response = new CourseResponse();
		response.setStatusMsg(courseException.getMessage());
		response.setResponseDate(java.time.LocalDate.now());
		return new ResponseEntity<CourseResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}