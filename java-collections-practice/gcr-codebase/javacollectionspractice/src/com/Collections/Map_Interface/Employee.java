package com.Collections.Map_Interface;

public class Employee {
	String name;
	String department;
	
	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}
	
	public String toString() {
		return name + " " + department;
	}
}