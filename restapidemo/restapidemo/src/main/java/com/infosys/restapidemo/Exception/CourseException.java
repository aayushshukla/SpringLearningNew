package com.infosys.restapidemo.Exception;

public class CourseException extends RuntimeException {
	
	public CourseException()
	{
		
	}
	
  public	CourseException(int id)
	{
		super("Could not find  course with id "+id);
	}

}
