package com.encapsulationandpolymorphism.VehicleRentalSystem;

public class Car extends Vehicle {
    // constructor
    public Car(int vehicleNumber, int rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicy);
    }

    // rental cost
    public int calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // insurance
    public int calculateInsurance() {
        return getRentalRate() / 10;
    }

    public void getInsuranceDetails() {
        System.out.println("Car insurance : " + calculateInsurance());
    }
}