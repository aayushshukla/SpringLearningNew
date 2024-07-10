package com.infosys.admin.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter @Entity
@Table(name="admin_info")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminId;
	@NotEmpty(message = "Admin name required")
	String adminName;
	@NotEmpty(message = "Admin password required")
	@Size(min = 8,max = 16 , message = "Password must be greater than 8 and less than 17")
	String adminPassword;

}
