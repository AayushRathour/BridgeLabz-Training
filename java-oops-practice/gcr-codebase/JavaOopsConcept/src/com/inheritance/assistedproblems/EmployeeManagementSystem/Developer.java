package com.inheritance.assistedproblems.EmployeeManagementSystem;

public class Developer extends Employee{
	private String programmingLanguage;

	// constructor
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	// getter and setter
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public Developer(int id, String name, int salary, String programmingLanguage) {
		super(id, name, salary);
		this.programmingLanguage = programmingLanguage;
	}
}
