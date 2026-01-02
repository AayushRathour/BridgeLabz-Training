package com.encapsulationandpolymorphism.RideHailingApplication;

public class Car extends Vehicle {
    // constructor
    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}