package com.med.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.med.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String>{
	
	List<Doctor> findByFirstNameContainingIgnoreCase(String firstName);

}

