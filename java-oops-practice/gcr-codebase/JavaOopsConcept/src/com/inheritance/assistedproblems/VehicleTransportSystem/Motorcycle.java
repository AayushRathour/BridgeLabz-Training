package com.inheritance.assistedproblems.VehicleTransportSystem;

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    // constructor
    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

	// display method
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
    
    // getter and setter
    public boolean isHasSidecar() {
		return hasSidecar;
	}

	public void setHasSidecar(boolean hasSidecar) {
		this.hasSidecar = hasSidecar;
	}
}