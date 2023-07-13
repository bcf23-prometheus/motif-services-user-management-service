package com.surokkha.usermanagementservice.user.service;

import com.surokkha.usermanagementservice.user.repository.UserRepository;
import com.surokkha.usermanagementservice.user.dto.SignupDto;
import com.surokkha.usermanagementservice.user.exception.BirthCertificatedIdAlreadyRegisteredException;
import com.surokkha.usermanagementservice.user.exception.NidAlreadyRegisteredException;
import com.surokkha.usermanagementservice.user.exception.UserNotFoundException;
import com.surokkha.usermanagementservice.user.mapper.UserMapper;
import com.surokkha.usermanagementservice.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	// TODO: Most of the operations can be done in a single pass. Optimize later
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	@SneakyThrows
	@Override
	public User signUp(SignupDto signupDto) {
		var existingUser = userRepository.findByNid(signupDto.getNid());
		if (existingUser.isPresent()) {
			throw new NidAlreadyRegisteredException(signupDto.getNid());
		}
		existingUser = userRepository.findByBirthCertificateId(signupDto.getBirthCertificateId());
		if (existingUser.isPresent()) {
			throw new BirthCertificatedIdAlreadyRegisteredException(signupDto.getBirthCertificateId());
		}
		
		var user = userMapper.toEntity(signupDto);
		user.setPassword(hashPassword(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User getUser(String id) {
		return userRepository.findById(id)
		                     .orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
		                     .orElseThrow(() -> new UserNotFoundException(email));
	}
	
	// FIXME: This is a temporary implementation. It should be replaced with a proper hashing algorithm.
	private String hashPassword(String password) {
		return password;
	}
	
	@Override
	public boolean checkHashedPassword(String hashedPassword, String password) {
		return hashedPassword.equals(hashPassword(password));
	}
	
}
