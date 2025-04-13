package com.sag.employee.service.utility;

import org.springframework.stereotype.Component;

import com.sag.employee.service.dto.EmployeeForm;
import com.sag.employee.service.entity.Employee;

@Component
public class Converter {
	
	public Employee getEmployee(EmployeeForm employeeForm) {
		return Employee.builder()
				.id(employeeForm.getId())
				.name(employeeForm.getName())
				.address(employeeForm.getAddress())
				.salary(employeeForm.getSalary())
				.deptId(employeeForm.getDeptId())
				.build();
	}
	
	public EmployeeForm getEmployeeForm(Employee employee) {
		return EmployeeForm.builder()
				.id(employee.getId())
				.name(employee.getName())
				.address(employee.getAddress())
				.salary(employee.getSalary())
				.deptId(employee.getDeptId())
				.build();
	}

}
