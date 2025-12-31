package com.objectmodelling.level1.companyanddepartments;

import java.util.ArrayList;

public class Company {
	private String name;
	ArrayList<Department> departments;
	
	// constructor
	public Company(String name) {
		this.name = name;
		departments = new ArrayList<Department>();
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}
	
	// method to delete company
	public void deleteCompany() {
		for(Department department : departments) department.clearEmployees();
		departments.clear();
	}
	
	// method to add department
	public void addDepartment(String name) {
		departments.add(new Department(name));
	}
}