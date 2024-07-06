package com.infosys.restapidemo.Models;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class CourseResponse {
	
	private int statusCode;
	private String statusMsg;
	private LocalDate responseDate;
	

}
