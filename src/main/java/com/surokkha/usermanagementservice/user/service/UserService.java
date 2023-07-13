package com.surokkha.usermanagementservice.user.service;

import com.surokkha.usermanagementservice.user.dto.SignupDto;
import com.surokkha.usermanagementservice.user.model.User;

public interface UserService {
	
	User signUp(SignupDto signupDto);
	
	User getUser(String id);
	
	User getUserByEmail(String email);
	
	boolean checkHashedPassword(String hashedPassword, String password);
}
