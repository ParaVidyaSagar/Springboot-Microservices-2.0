package com.sag.department.service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sag.department.service.entity.Department;
import com.sag.department.service.exception.DepartmentNotFoundException;
import com.sag.department.service.repository.DepartmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	@Transactional
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department getDepartment(Long id) throws DepartmentNotFoundException{
		Optional<Department> optDept = departmentRepository.findById(id);
		if(optDept.isPresent()) return optDept.get();
		throw new DepartmentNotFoundException("Department is Not Found!!");
	}

}
