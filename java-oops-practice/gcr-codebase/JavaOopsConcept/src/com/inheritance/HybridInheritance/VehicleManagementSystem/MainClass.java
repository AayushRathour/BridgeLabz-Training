package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class MainClass {
	public static void main(String[] args) {
		// creating objects
        ElectricVehicle evelElectricVehicle = new ElectricVehicle(120, "EV1");
        PetrolVehicle perPetrolVehicle = new PetrolVehicle(200, "PV1");

        evelElectricVehicle.displayInfo();
        evelElectricVehicle.charge();
        perPetrolVehicle.displayInfo();
        perPetrolVehicle.refuel();
    }
}
