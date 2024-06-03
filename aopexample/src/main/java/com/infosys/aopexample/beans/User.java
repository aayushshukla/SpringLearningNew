package com.infosys.aopexample.beans;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String userName="Edgeverve";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void show()
	{
		System.out.println("Welcome user "+userName);
	}

}
