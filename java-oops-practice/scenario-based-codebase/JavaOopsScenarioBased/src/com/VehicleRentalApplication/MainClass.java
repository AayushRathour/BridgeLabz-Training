package com.VehicleRentalApplication;

public class MainClass {
	public static void main(String[] args) {

        Customer customer = new Customer("Aayush");

        Rentable bike = new Bike("BK101");
        Rentable car = new Car("CR202");
        Rentable truck = new Truck("TR303");

        customer.rentVehicle(bike, 2);
        customer.rentVehicle(car, 3);
        customer.rentVehicle(truck, 1);
    }

}
