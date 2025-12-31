package com.objectmodelling.level1.companyanddepartments;

import java.util.ArrayList;

public class Department {
	private String name;
	ArrayList<Employee> employees;
	
	// method to add employees
	public void addEmployee(int id, String name) {
		employees.add(new Employee(id, name));
	}
	
	// getters and setters
	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void clearEmployees() {
		employees.clear();
	}
}