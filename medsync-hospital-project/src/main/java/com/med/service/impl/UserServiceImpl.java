package com.med.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.med.dao.UserRepository;
import com.med.dto.LoginDTO;
import com.med.exception.InvalidCredentialsException;
import com.med.model.User;
import com.med.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public User resetPassword(LoginDTO loginDTO) {
		User user = userRepository.findUserByEmail(loginDTO.getUserEmail());
		
		if(user==null) {
			throw new InvalidCredentialsException("Invalid email");
		}
		
		user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}

