package com.RideHailingApp;

public class SUV extends Vehicle {
    private int baseFare = 120;

    public SUV(String vehicleNumber) {
        super(vehicleNumber, 6, "SUV", 20);
    }

    public int bookRide(int distance) {
        int totalFare = baseFare + distance * 20;
        setFare(totalFare);
        return totalFare;
    }

    public void endRide() {
        System.out.println("SUV ride ended : " + getFare());
    }
}