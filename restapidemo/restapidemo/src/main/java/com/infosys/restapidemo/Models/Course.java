package com.infosys.restapidemo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name="mycourses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int courseId;
	@NotBlank(message="Course name can not be empty")
	@Size(min=5, message="Name must be 5 letter long")
	String courseName;
	@NotNull(message="Duration is required")
	int duration;
	//@Pattern(regexp = "(^$|[0-9]{10})",message="mobile must be 10 digit long")
	//String mobileNo;
	
	public Course(int courseId,
			@NotBlank(message = "Course name can not be empty") @Size(min = 5, message = "Name must be 5 letter long") String courseName,
			@NotBlank(message = "Duration is required") int duration) {
	
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
	}
	
	// @NotNull check if given field is not null but allow empty values and 
	//zero element inside collection
	
	//@NotEmpty check if given field is not null and size is greater than zero
	
	//@NotBlank check if given field is not null and trimmed length is greater than zero

	
}
