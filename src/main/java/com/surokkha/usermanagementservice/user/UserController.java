package com.surokkha.usermanagementservice.user;

import com.surokkha.domain.response.ApiResponse;
import com.surokkha.usermanagementservice.authentication.AuthenticationStrategies;
import com.surokkha.usermanagementservice.user.constants.UserMessages;
import com.surokkha.usermanagementservice.user.dto.SignupDto;
import com.surokkha.usermanagementservice.user.dto.UserDto;
import com.surokkha.usermanagementservice.user.dto.UserPrincipalDto;
import com.surokkha.usermanagementservice.user.mapper.UserMapper;
import com.surokkha.usermanagementservice.user.model.User;
import com.surokkha.usermanagementservice.user.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.Map;

import static com.surokkha.usermanagementservice.user.constants.UserMessages.USER_CREATED_SUCCESSFULLY;

@RestController
@RequestMapping ("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final UserMapper userMapper;
	
	@PostMapping ("/signup")
	public ApiResponse<UserDto> signup(@Valid @RequestBody SignupDto signupDto) {
		var user = userService.signUp(signupDto);
		
		return ApiResponse.<UserDto>builder()
		                  .message(USER_CREATED_SUCCESSFULLY.getMessage())
		                  .data(userMapper.toDto(user))
		                  .build();
	}
	
	@GetMapping ("/{id}")
	public UserDto getSimpleUser(@PathVariable String id) {
		var user = userService.getUser(id);
		return userMapper.toDto(user);
	}
	
	@PostMapping ("/principal")
	@io.swagger.v3.oas.annotations.parameters.RequestBody (required = true,
			content = @Content (mediaType = "application/json",
					schema = @Schema (implementation = Map.class),
					examples = @ExampleObject (value = "{\n" + "  \"email\": \"admin@lms.edu\",\n" + "  \"password\": \"12345678\"\n" + "}")))
	public UserPrincipalDto getUserPrincipal(HttpServletRequest request, @RequestParam String strategy) {
		var user = AuthenticationStrategies.getAuthenticatedUser(strategy, request);
		return userMapper.toPrincipalDto(user);
	}
}
