package com.surokkha.usermanagementservice.user.exception;

import com.surokkha.restexception.exception.RESTException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RESTException {
	
	public UserNotFoundException(String email) {
		super("User with email " + email + " not found");
		status = HttpStatus.NOT_FOUND;
	}
}
