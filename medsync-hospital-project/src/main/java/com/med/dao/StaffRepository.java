package com.med.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.med.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, String>{
	
	List<Staff> findByFirstNameContainingIgnoreCase(String name);
}