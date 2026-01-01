package com.inheritance.assistedproblems.VehicleTransportSystem;

public class DriverClass {
	public static void main(String[] args) {
        // Create 
        Vehicle car = new Car(180, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 10);
        Vehicle motorcycle = new Motorcycle(150, "Petrol", true);

        // Store all vehicles in a Vehicle array
        Vehicle[] vehicles = {car, truck, motorcycle};

        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}