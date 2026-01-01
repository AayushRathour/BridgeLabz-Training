package com.inheritance.assistedproblems.AnimalHierarchy;

public class Dog extends Animal{
	// constructor
	public Dog(String name, int age) {
		super(name, age);
	}
	
	// overriding methods
	public void makeSound() {
		System.out.println("Dog Sound!");
	}
}