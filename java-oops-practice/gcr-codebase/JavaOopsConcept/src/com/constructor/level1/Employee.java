package com.constructor.level1;

public class Employee {
	public int employeeID;
	protected String department;
	private int salary;
	
	// getter for salary
	public int getSalary() {
		return salary;
	}
	
	// setter for salary
	public void setSalary(int salary) {
		this.salary = salary;
	}
}