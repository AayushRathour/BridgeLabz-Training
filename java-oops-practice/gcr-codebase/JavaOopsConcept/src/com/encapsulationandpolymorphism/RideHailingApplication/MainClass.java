package com.encapsulationandpolymorphism.RideHailingApplication;

import java.util.*;

public class MainClass {
    public static void calculateFareForAll(List<Vehicle> list, double distance) {
        for (Vehicle vehicle : list) {
            vehicle.getVehicleDetails();
            System.out.println("Fare : " + vehicle.calculateFare(distance));
        }
    }

    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();

        list.add(new Car(1, "Aayush", 15));
        list.add(new Bike(2, "Harsh", 8));
        list.add(new Auto(3, "driver", 10));

        calculateFareForAll(list, 12.5);
    }
}