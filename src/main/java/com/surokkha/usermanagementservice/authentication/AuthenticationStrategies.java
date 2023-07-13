package com.surokkha.usermanagementservice.authentication;

import com.surokkha.usermanagementservice.authentication.strategies.AuthenticationStrategy;
import com.surokkha.usermanagementservice.authentication.strategies.local.PasswordAuthenticationStrategy;
import com.surokkha.usermanagementservice.config.ApplicationContextProvider;
import com.surokkha.usermanagementservice.user.model.User;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;

public enum AuthenticationStrategies {
	LOCAL(PasswordAuthenticationStrategy.class);
	
	private final Class<? extends AuthenticationStrategy> authenticationStrategist;
	
	AuthenticationStrategies(Class<? extends AuthenticationStrategy> authenticationStrategist) {
		this.authenticationStrategist = authenticationStrategist;
	}
	
	public static User getAuthenticatedUser(String method, HttpServletRequest request) {
		var applicationContext = ApplicationContextProvider.getApplicationContext();
		var strategist = applicationContext.getBean(AuthenticationStrategies.valueOf(method.toUpperCase(Locale.ROOT)).authenticationStrategist);
		strategist.setRequest(request);
		return strategist.getAuthenticatedUser();
	}
	
}
