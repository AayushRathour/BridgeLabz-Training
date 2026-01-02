package com.encapsulationandpolymorphism.RideHailingApplication;

public class Bike extends Vehicle {
    // constructor
    public Bike(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}