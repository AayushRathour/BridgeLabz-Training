package com.VehicleRentalApplication;

public class Truck extends Vehicle implements Rentable  {
	Truck(String vehicleNumber){
		super(vehicleNumber, 13212);
	}
	
	public double calculateRent(int days) {
		double loadCharge =500*days;
		return (getBaseRate()*days)+loadCharge;
		
	}
	
}
