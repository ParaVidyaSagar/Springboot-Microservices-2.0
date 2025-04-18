package com.med.service;

import com.med.dto.LoginDTO;
import com.med.model.User;

public interface UserService {
	
	public User resetPassword(LoginDTO loginDTO);

}

