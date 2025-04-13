package com.sag.employee.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sag.employee.service.dto.EmployeeForm;
import com.sag.employee.service.dto.Response;
import com.sag.employee.service.entity.Employee;
import com.sag.employee.service.exception.DepartmentNotFoundException;
import com.sag.employee.service.exception.EmployeeNotFoundException;
import com.sag.employee.service.service.EmployeeService;
import com.sag.employee.service.utility.Converter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	private final Converter converter;
	
	@PostMapping("/saveEmployee")
	public EmployeeForm saveEmployee(@RequestBody EmployeeForm employeeForm) {
		Employee emp =converter.getEmployee(employeeForm);
		emp = employeeService.saveEmployee(emp);
		return converter.getEmployeeForm(emp);
	}
	
	@GetMapping("/getEmployee/{id}")
	public Response getEmployee(@PathVariable Long id) throws EmployeeNotFoundException, DepartmentNotFoundException{
		return getEmployeeForm(id);
	}
	
	@GetMapping("/getEmployee")
	public Response getEmployeeParam(@RequestParam("emp_id") Long id) throws EmployeeNotFoundException, DepartmentNotFoundException{
		return getEmployeeForm(id);
	}
	
	private Response getEmployeeForm(Long id) throws EmployeeNotFoundException, DepartmentNotFoundException {
		return employeeService.getEmployee(id);
	}
}
