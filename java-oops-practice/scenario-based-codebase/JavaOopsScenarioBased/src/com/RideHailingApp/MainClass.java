package com.RideHailingApp;

public class MainClass {
    public static void main(String[] args) {
        Vehicle mini = new Mini("MP05");
        Vehicle sedan = new Sedan("MP04");

        Driver driver1 = new Driver("Aman", "0", 4);
        Driver driver2 = new Driver("Tarun", "1", 4.8);

        driver1.displayDriver();
        System.out.println("Mini Fare : " + mini.bookRide(10));
        mini.endRide();

        driver2.displayDriver();
        System.out.println("Sedan Fare : " + sedan.bookRide(10));
        sedan.endRide();
    }
}