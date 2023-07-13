package com.surokkha.usermanagementservice.user.exception;

import com.surokkha.restexception.exception.RESTException;
import org.springframework.http.HttpStatus;

public class NidAlreadyRegisteredException extends RESTException {
	
	public NidAlreadyRegisteredException(String nid) {
		super("User with nid " + nid + " already exists");
		status = HttpStatus.CONFLICT;
	}
}
