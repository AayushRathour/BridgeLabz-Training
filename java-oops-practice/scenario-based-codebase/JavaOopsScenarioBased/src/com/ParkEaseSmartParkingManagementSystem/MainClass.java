package com.ParkEaseSmartParkingManagementSystem;

public class MainClass {
    public static void main(String[] args) {
        ParkingSlot slot1 = new ParkingSlot(1, "Block A", "Car");
        ParkingSlot slot2 = new ParkingSlot(2, "Block B", "Bike");

        Vehicle car = new Car("Car01");
        Vehicle bike = new Bike("Bike02");

        if(slot1.parkVehicle(car)) {
            System.out.println("Car parked. Charges: " + car.calculateCharges(6));
        }

        if(slot2.parkVehicle(bike)) {
            System.out.println("Bike parked. Charges: " + bike.calculateCharges(3));
        }

        slot1.showLog();
        slot2.showLog();

        slot1.vacateSlot();
        slot1.showLog();
    }
}