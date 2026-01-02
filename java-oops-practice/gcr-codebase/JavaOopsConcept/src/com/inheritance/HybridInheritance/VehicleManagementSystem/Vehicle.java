package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class Vehicle {
    public int maxSpeed;
    public String model;

    // constructor
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    // display
    public void displayInfo() {
        System.out.println(model + " | " + maxSpeed);
    }
}