package com.encapsulationandpolymorphism.EmployeeManagementSystem;

public class PartTimeEmployee extends Employee{

	public PartTimeEmployee(int employeeId, String name) {
		super(employeeId, name, 50000);
	}
	
	public int calculateSalary() {
		return 50000;
	}
}