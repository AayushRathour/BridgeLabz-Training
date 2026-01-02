package com.inheritance.HybridInheritance.RestaurantManagementSystem;

public class MainClass {
	public static void main(String[] args) {
		// creating object
        Chef chef = new Chef(0, "chef name");
        Waiter waiter = new Waiter(1, "waiter name");

        chef.displayDetails();
        chef.performDuties();
        waiter.displayDetails();
        waiter.performDuties();
    }
}