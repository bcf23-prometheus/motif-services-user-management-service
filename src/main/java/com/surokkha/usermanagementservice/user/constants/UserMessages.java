package com.surokkha.usermanagementservice.user.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserMessages {
	USER_CREATED_SUCCESSFULLY("user created successfully");
	
	private final String message;
}
