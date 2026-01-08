package com.ParkEaseSmartParkingManagementSystem;

public class Truck extends Vehicle {
    public Truck(String vehicleNumber) {
        super(vehicleNumber, "Truck");
    }

    public double calculateCharges(int hours) {
        double baseRate = 80;
        double penalty = hours > 5 ? 200 : 0;
        return (baseRate * hours) + penalty;
    }
}