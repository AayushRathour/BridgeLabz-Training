package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class PetrolVehicle extends Vehicle implements Refuelable {
	// constructor
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    // method from interface
    public void refuel() {
        System.out.println("Refuling petrol vehicle");
    }
}