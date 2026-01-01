package com.inheritance.assistedproblems.AnimalHierarchy;

public class Bird extends Animal{
	// constructor
	public Bird(String name, int age) {
		super(name, age);
	}
	
	// overriding methods
	public void makeSound() {
		System.out.println("Bird Sound!");
	}
}