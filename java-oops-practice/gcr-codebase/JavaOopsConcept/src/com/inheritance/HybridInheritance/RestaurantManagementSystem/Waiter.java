package com.inheritance.HybridInheritance.RestaurantManagementSystem;

public class Waiter extends Person implements Worker {
	// constructor
    public Waiter(int id, String name) {
        super(id, name);
    }

    // method from interface
    public void performDuties() {
        System.out.println(" waiter is serving");
    }
}