package com.employeepayroll.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employeepayroll.Dto.EmployeeRequestDTO;
import com.employeepayroll.Dto.EmployeeSearchDTO;
import com.employeepayroll.Entity.Employee;

public interface EmployeeService {

	Employee addEmployee(EmployeeRequestDTO request);
	// Returns one requested page using the sort carried by Pageable.
	Page<Employee> getAllEmployees(Pageable pageable);
	// Finds employees whose non-null fields match the supplied search example.
	Page<Employee> searchEmployees(EmployeeSearchDTO criteria, Pageable pageable);
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Long id, EmployeeRequestDTO request);
	void deleteEmployee(Long id);
}
