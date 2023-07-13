package com.surokkha.usermanagementservice.authentication.strategies;

import com.surokkha.usermanagementservice.user.model.User;
import lombok.Setter;

import jakarta.servlet.http.HttpServletRequest;

public abstract class AuthenticationStrategy {
	
	@Setter
	protected HttpServletRequest request;
	
	public abstract User getAuthenticatedUser();
}
