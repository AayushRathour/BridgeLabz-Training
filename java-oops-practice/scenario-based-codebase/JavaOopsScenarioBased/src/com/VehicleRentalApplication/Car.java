package com.VehicleRentalApplication;

public class Car extends Vehicle implements Rentable{
	Car(String vehicleNumber){
		super(vehicleNumber, 175632);
	}
	
	public double calculateRent(int days) {
		double uo = 100*days;
		return (getBaseRate()*days)+uo;
		
	}
}


