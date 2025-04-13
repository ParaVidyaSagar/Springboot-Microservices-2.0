package com.sag.department.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sag.department.service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
