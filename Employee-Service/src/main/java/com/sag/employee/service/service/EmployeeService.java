package com.sag.employee.service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sag.employee.service.Repository.EmployeeRepository;
import com.sag.employee.service.client.DepartmentClient;
import com.sag.employee.service.dto.DepartmentForm;
import com.sag.employee.service.dto.EmployeeForm;
import com.sag.employee.service.dto.Response;
import com.sag.employee.service.entity.Employee;
import com.sag.employee.service.exception.DepartmentNotFoundException;
import com.sag.employee.service.exception.EmployeeNotFoundException;
import com.sag.employee.service.utility.Converter;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	//private final RestTemplate restTemplate
	private final DepartmentClient departmentClient;
	private final Converter converter;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Response getEmployee(Long id) throws EmployeeNotFoundException, DepartmentNotFoundException{
		Response response = new Response();
		EmployeeForm eForm = null;
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if (optEmp.isPresent()) { 
			eForm = converter.getEmployeeForm(optEmp.get());
			response.setEmployeeForm(eForm);
		}else
			throw new EmployeeNotFoundException("Employee is not found!!");
		//DepartmentForm departmentForm = restTemplate.getForObject("http://DEPARTMENT-SERVICE/dept/getDepartment/"+eForm.getDeptId(), DepartmentForm.class);
		DepartmentForm departmentForm = departmentClient.getDepartment(eForm.getDeptId());
		response.setDepartmentForm(departmentForm);
		return response; 
	}

	
	

}
