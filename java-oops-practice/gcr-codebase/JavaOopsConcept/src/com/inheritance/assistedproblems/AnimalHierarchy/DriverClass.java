package com.inheritance.assistedproblems.AnimalHierarchy;

public class DriverClass {
	public static void main(String[] agrs) {
		// creating object
		Bird bird = new Bird("Eagle", 5);
		Cat cat = new Cat("cat name", 1);
		Dog dog = new Dog("dog name", 2);
		
		// calling method
		bird.makeSound();
		cat.makeSound();
		dog.makeSound();
	}
}