package com.RideHailingApp;

public abstract class Vehicle implements IRideService {
    protected String vehicleNumber;
    protected int capacity;
    protected String type;
    private int ratePerKm;
    private int fare;

    public Vehicle(String vehicleNumber, int capacity, String type, int ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.ratePerKm = ratePerKm;
    }

    protected void setFare(int fare) {
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }
}