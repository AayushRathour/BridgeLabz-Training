package com.encapsulationandpolymorphism.EmployeeManagementSystem;

public abstract class Employee implements Departments{
	private int employeeId;
	private String name;
	private int baseSalary;
	private String department;
	
	// constructor
	public Employee(int employeeId, String name, int baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	// abstract method
	public abstract int calculateSalary();
	
	// method to display
	public void displayDetails() {
		System.out.println("Id " + employeeId + " name : " + name);
	}
	
	// getter and setter
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void assignDepartments(String department) {
		this.department = department;
	}
		
	public void getDepartments() {
		System.out.pritnln("Department : " + department);
	}
}