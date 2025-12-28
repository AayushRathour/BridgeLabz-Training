package com.constructor.level1;

public class Manager extends Employee{
	public static void main(String[] args) {
		// creating object and accessing  employeeID and department.
		Employee emp = new Employee();
		emp.employeeID = 1;
		emp.department = "management";
		
		System.out.println(emp.employeeID + " " + emp.department);
	}
}