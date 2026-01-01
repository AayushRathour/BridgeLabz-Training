package com.inheritance.assistedproblems.AnimalHierarchy;

public class Cat extends Animal{
	// constructor
	public Cat(String name, int age) {
		super(name, age);
	}
	
	// overriding methods
	public void makeSound() {
		System.out.println("Cat Sound!");
	}
}