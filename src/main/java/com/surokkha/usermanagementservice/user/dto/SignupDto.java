package com.surokkha.usermanagementservice.user.dto;

import com.surokkha.usermanagementservice.user.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignupDto implements Serializable {
	
	@NotBlank
	@Length (min = 3, max = 50)
	private String name;
	
	@NotBlank
	private Date dob;
	
	@NotBlank
	@Length (min = 11, max = 11)
	private String phone;
	
	@Length (min = 10, max = 10)
	private String nid;
	
	@Length (min = 17, max = 17)
	private String birthCertificateId;
	
	private UserRole userRole;
	
	private String password;
}