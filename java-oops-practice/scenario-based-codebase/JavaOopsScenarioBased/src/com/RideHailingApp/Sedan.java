package com.RideHailingApp;

public class Sedan extends Vehicle {
    private int baseFare = 80;

    public Sedan(String vehicleNumber) {
        super(vehicleNumber, 4, "Sedan", 15);
    }

    public int bookRide(int distance) {
        int totalFare = baseFare + distance * 15;
        setFare(totalFare);
        return totalFare;
    }

    public void endRide() {
        System.out.println("Sedan ride ended : " + getFare());
    }
}