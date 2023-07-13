package com.surokkha.usermanagementservice.user.mapper;

import com.surokkha.usermanagementservice.user.dto.SignupDto;
import com.surokkha.usermanagementservice.user.dto.UserDto;
import com.surokkha.usermanagementservice.user.dto.UserPrincipalDto;
import com.surokkha.usermanagementservice.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
	
	UserDto toDto(User entity);
	
	User toEntity(UserDto dto);
	
	User toEntity(SignupDto dto);
	
	UserPrincipalDto toPrincipalDto(User entity);
}
