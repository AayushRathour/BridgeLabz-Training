package com.encapsulationandpolymorphism.VehicleRentalSystem;

public class Truck extends Vehicle {
    // constructor
    public Truck(int vehicleNumber, int rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicy);
    }

    // rental cost
    public int calculateRentalCost(int days) {
        return (getRentalRate() * days);
    }

    // insurance
    public int calculateInsurance() {
        return getRentalRate() / 5;
    }

    public void getInsuranceDetails() {
        System.out.println("Truck insurance : " + calculateInsurance());
    }
}