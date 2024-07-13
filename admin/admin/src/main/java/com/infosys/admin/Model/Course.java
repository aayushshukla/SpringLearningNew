package com.infosys.admin.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Course {
		int courseId;
		String courseName;
		int duration;
		
		
		
		// @NotNull check if given field is not null but allow empty values and 
		//zero element inside collection
		
		//@NotEmpty check if given field is not null and size is greater than zero
		
		//@NotBlank check if given field is not null and trimmed length is greater than zero

		
	}

