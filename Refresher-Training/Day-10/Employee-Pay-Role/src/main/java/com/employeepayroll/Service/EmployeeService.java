package com.employeepayroll.Service;

import java.util.List;

import com.employeepayroll.Entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Long id, Employee employee);
	void deleteEmployee(Long id);
}
