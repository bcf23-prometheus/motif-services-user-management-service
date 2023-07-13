package com.surokkha.usermanagementservice.common.handlers;

import com.surokkha.domain.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class UserManagementServiceExceptionHandler {
	
	protected static final Logger errorLogger = LoggerFactory.getLogger("errorLogger");
	
	@ExceptionHandler (Exception.class)
	public final ApiResponse<String> commonException(Exception ex) {
		errorLogger.error(ex.getLocalizedMessage(), ex);
		return ApiResponse.<String>builder()
		                  .message(ex.getLocalizedMessage())
		                  .data(ex.toString())
		                  .build();
	}
}
