package com.RideHailingApp;

public class Mini extends Vehicle {
    private int baseFare = 50;

    public Mini(String vehicleNumber) {
        super(vehicleNumber, 4, "Mini", 10);
    }

    public int bookRide(int distance) {
        int totalFare = baseFare + distance * 10;
        setFare(totalFare);
        return totalFare;
    }

    public void endRide() {
        System.out.println("Mini ride end : " + getFare());
    }
}