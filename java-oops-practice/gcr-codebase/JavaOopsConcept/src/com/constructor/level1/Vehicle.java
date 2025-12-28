package com.constructor.level1;

public class Vehicle {

    // instance variables
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000;

    // constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // static method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        // creating vehicle objects
        Vehicle v1 = new Vehicle("Aayush", "Car");
        Vehicle v2 = new Vehicle("Rathour", "Bike");

        // displaying initial details
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6000);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
