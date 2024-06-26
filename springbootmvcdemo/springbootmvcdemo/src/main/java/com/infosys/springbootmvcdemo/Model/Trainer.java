package com.infosys.springbootmvcdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Trainer {
	private  int trainerId;
	private String trainerName;
	private String trainerEmail;
	private String trainerPassword;
	private int exp;
	
	

}
