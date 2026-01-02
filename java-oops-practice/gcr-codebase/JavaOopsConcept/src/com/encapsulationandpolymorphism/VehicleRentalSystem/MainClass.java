package com.encapsulationandpolymorphism.VehicleRentalSystem;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
    	// storing in array list of Vehicle
        List<Vehicle> list = new ArrayList<>();
        list.add(new Car(0, 2000, "Car"));
        list.add(new Bike(1, 800, "bike"));
        list.add(new Truck(2, 5000, "truck"));

        for (Vehicle v : list) {
            System.out.println(v.getType() + " : " + v.calculateRentalCost(3));
            v.getInsuranceDetails();
        }
    }
}