package com.encapsulationandpolymorphism.VehicleRentalSystem;

public abstract class Vehicle implements Insurable {
    private int vehicleNumber;
    private String type;
    private int rentalRate;
    private String insurancePolicy;

    // constructor
    public Vehicle(int vehicleNumber, String type, int rentalRate, String insurancePolicy) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicy = insurancePolicy;
    }

    // abstract method
    public abstract int calculateRentalCost(int days);

    // getter
    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public int getRentalRate() {
        return rentalRate;
    }

    public String getInsurancePolicy() {
        return "Policy Protected";
    }
}