package com.VehicleRentalApplication;

public class Customer {
	private String name;
	Customer(String name){
		this.name = name;
	}
	void setName(String name) {
		this.name= name;
	}
	String getName() {
		return name;
	}
	void rentVehicle(Rentable r, int days) {
        System.out.println("Customer Name: " + name);
        System.out.println("Rent Amount: " + r.calculateRent(days));
    }
	
}
