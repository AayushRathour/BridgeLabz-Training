package com.encapsulationandpolymorphism.RideHailingApplication;

public abstract class Vehicle implements GPS {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // constructor
    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "location";
    }

    // abstract method
    public abstract double calculateFare(double distance);

    // concrete method
    public void getVehicleDetails() {
        System.out.println(vehicleId + " " + driverName + " " + ratePerKm);
    }

    // getter and setter
    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}