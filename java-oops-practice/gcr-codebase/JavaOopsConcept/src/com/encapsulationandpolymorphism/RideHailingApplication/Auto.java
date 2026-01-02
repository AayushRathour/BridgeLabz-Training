package com.encapsulationandpolymorphism.RideHailingApplication;

public class Auto extends Vehicle {
    // constructor
    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}