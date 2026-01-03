package com.VehicleRentalApplication;

public class Vehicle {
	protected String vehicleNumber;
    protected double baseRate;

    Vehicle(String vehicleNumber, double baseRate) {
        this.vehicleNumber = vehicleNumber;
        this.baseRate = baseRate;
    }

    String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
    	this.vehicleNumber = vehicleNumber;
    	
    }

    double getBaseRate() {
        return baseRate;
    }
    public void setBaseRate(double baseRate) {
    	this.baseRate = baseRate;
    	
    }
}