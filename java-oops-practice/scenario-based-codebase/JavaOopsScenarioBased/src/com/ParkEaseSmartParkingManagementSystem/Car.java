package com.ParkEaseSmartParkingManagementSystem;

public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber, "Car");
    }

    public double calculateCharges(int hours) {
        double baseRate = 50;
        double penalty = hours > 5 ? 100 : 0;
        return (baseRate * hours) + penalty;
    }
}