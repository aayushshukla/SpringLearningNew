package com.infosys.springbootmvcdemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "trainer_data")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int trainerId;
	@NotBlank(message = "trainerName can not be empty")
	private String trainerName;
	@NotBlank(message = "trainer email can not be empty")
	private String trainerEmail;
	@NotBlank(message = "trainerPassword can not be empty")
	private String trainerPassword;
	@NotNull(message = "trainerexp can not be empty")
	private int exp;
	
	

}
