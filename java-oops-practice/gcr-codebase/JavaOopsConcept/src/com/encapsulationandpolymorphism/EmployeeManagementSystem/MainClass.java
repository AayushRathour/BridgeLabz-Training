package com.encapsulationandpolymorphism.EmployeeManagementSystem;

public class MainClass {
	public static void main(String[] args) {
		// creating object and calling fucntions
		Employee fullTimeEmp = new FullTimeEmployee(0, "Aayush");
		Employee partEmployee = new PartTimeEmployee(1, "Harsh");
		
		fullTimeEmp.assignDepartments("Dev");
		partEmployee.assignDepartments("Deployment");
		
		System.out.println(fullTimeEmp.calculateSalary());
		System.out.println(partEmployee.calculateSalary());
		fullTimeEmp.displayDetails();
		partEmployee.displayDetails();
	}
}