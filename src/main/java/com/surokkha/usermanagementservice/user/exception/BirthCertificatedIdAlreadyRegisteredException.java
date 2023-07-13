package com.surokkha.usermanagementservice.user.exception;

import com.surokkha.restexception.exception.RESTException;
import org.springframework.http.HttpStatus;

public class BirthCertificatedIdAlreadyRegisteredException extends RESTException {
	
	public BirthCertificatedIdAlreadyRegisteredException(String birthCertificateId) {
		super("User with birth certificate id" + birthCertificateId + " already exists");
		status = HttpStatus.CONFLICT;
	}
}
