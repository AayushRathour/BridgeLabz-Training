package com.ParkEaseSmartParkingManagementSystem;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber, "Bike");
    }

    public double calculateCharges(int hours) {
        double baseRate = 20;
        double penalty = hours > 5 ? 50 : 0;
        return (baseRate * hours) + penalty;
    }
}