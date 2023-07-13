package com.surokkha.usermanagementservice.authentication.strategies.local;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class PasswordAuthenticationDto implements Serializable {
	
	@NotBlank
	@Email (regexp = "^[a-zA-Z0-9_.+-]+@lms.edu$", message = "Email must be a valid LMS email address")
	private String email;
	
	@NotBlank
	@Length (min = 8, max = 20)
	private String password;
	
}
