package com.inheritance.assistedproblems.EmployeeManagementSystem;

public class DriverClass {
	public static void main(String[] args) {
		Intern intern = new Intern(0, "Intern name", 10000);
		Developer developer = new Developer(1, "Developer name", 100000, "Java");
		Manager manager = new Manager(2, "Manager name", 50000, 10);
		
		intern.displayDetails();
		developer.displayDetails();
		manager.displayDetails();
	}
}