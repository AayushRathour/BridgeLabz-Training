package com.VehicleRentalApplication;

public class Bike extends Vehicle implements Rentable{
		Bike(String vehicleNumber){
			super(vehicleNumber, 13432);
		}
		
		public double calculateRent(int days) {
			return getBaseRate()*days;
			
		}
}
