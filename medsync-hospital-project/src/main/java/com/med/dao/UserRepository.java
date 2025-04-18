package com.med.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.med.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findUserByEmail(String email);

}