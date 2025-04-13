package com.sag.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	private EmployeeForm employeeForm;
	private DepartmentForm departmentForm;

}
