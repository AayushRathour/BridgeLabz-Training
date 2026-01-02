package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class ElectricVehicle extends Vehicle {
	// constructor
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    // method to charage
    public void charge() {
        System.out.println("Charging electric vehicle");
    }
}