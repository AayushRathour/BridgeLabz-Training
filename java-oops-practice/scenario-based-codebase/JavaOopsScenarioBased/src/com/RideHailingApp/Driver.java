package com.RideHailingApp;

public class Driver {
    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public void displayDriver() {
        System.out.println(name + " " + rating);
    }
}