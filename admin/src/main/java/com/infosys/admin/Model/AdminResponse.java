package com.infosys.admin.Model;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class AdminResponse {
	
	private HttpStatusCode httpStatusCode;
	private String httpMessage;

}
