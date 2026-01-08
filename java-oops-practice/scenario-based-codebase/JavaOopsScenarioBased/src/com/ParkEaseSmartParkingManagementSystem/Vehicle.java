package com.ParkEaseSmartParkingManagementSystem;

public abstract class Vehicle implements IPayable {
    public String vehicleNumber;
    private String type;

    public Vehicle(String vehicleNumber, String type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}