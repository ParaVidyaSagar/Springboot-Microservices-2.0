package com.sag.employee.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sag.employee.service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
