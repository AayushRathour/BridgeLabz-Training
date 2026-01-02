package com.encapsulationandpolymorphism.VehicleRentalSystem;

public class Bike extends Vehicle {
    // constructor
    public Bike(int vehicleNumber, int rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicy);
    }

    // rental cost on the basis of days
    public int calculateRentalCost(int days) {
        return (getRentalRate() * days);
    }

    // insurance
    public int calculateInsurance() {
        return getRentalRate() / 20;
    }

    public void getInsuranceDetails() {
        System.out.println("Bike insurance : " + calculateInsurance());
    }
}