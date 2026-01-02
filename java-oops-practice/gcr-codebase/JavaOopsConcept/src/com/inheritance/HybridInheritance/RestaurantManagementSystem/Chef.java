package com.inheritance.HybridInheritance.RestaurantManagementSystem;

public class Chef extends Person implements Worker {
	// constructor
    public Chef(int id, String name) {
        super(id, name);
    }
    
    // method form interface
    public void performDuties() {
        System.out.println("Chef is cooking.");
    }
}