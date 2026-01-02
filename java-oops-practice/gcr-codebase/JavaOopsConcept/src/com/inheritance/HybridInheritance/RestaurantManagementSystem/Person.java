package com.inheritance.HybridInheritance.RestaurantManagementSystem;

public class Person {
    public String name;
    public int id;

    // constructor
    public Person(int id, String name) {
    	this.id = id;
        this.name = name;
    }
    
    // method to display details
    public void displayDetails() {
        System.out.println(id + " | " + name);
    }
}