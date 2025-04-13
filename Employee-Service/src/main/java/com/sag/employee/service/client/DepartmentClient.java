package com.sag.employee.service.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sag.employee.service.dto.DepartmentForm;
import com.sag.employee.service.exception.DepartmentNotFoundException;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {
	
	@GetMapping("/dept/getDepartment/{id}")
	public DepartmentForm getDepartment(@PathVariable Long id) throws DepartmentNotFoundException;
}
