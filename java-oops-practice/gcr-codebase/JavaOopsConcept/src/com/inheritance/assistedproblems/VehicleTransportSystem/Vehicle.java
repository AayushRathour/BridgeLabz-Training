package com.inheritance.assistedproblems.VehicleTransportSystem;

class Vehicle {
	private int maxSpeed;
    private String fuelType;

    // Constructor
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to display vehicle information
    public void displayInfo() {
        System.out.println(maxSpeed + " km/h" + "Fuel Type: " + fuelType);
    }
    
    // getter and setter
    public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
}