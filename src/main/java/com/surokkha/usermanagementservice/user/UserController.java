package com.surokkha.usermanagementservice.user;

import com.surokkha.usermanagementservice.authentication.AuthenticationStrategies;
import com.surokkha.usermanagementservice.user.dto.SignupDto;
import com.surokkha.usermanagementservice.user.dto.UserDto;
import com.surokkha.usermanagementservice.user.dto.UserPrincipalDto;
import com.surokkha.usermanagementservice.user.mapper.UserMapper;
import com.surokkha.usermanagementservice.user.model.User;
import com.surokkha.usermanagementservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final UserMapper userMapper;
	
	@PostMapping ("/signup")
	public User signup(@Valid @RequestBody SignupDto signupDto) {
		return userService.signUp(signupDto);
	}
	
	@GetMapping ("/{id}")
	public UserDto getSimpleUser(@PathVariable String id) {
		var user = userService.getUser(id);
		return userMapper.toDto(user);
	}
	
	@PostMapping ("/principal")
	public UserPrincipalDto getUserPrincipal(HttpServletRequest request, @RequestParam String strategy) {
		var user = AuthenticationStrategies.getAuthenticatedUser(strategy, request);
		return userMapper.toPrincipalDto(user);
	}
}
