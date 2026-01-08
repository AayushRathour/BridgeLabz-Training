package com.ParkEaseSmartParkingManagementSystem;

public class ParkingSlot {
    private int slotId;
    private boolean isOccupied;
    private String vehicleTypeAllowed;
    private String location;
    private String bookingLog;

    public ParkingSlot(int slotId, String location, String vehicleTypeAllowed) {
        this.slotId = slotId;
        this.location = location;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;
        this.bookingLog = "Empty";
    }

    public boolean parkVehicle(Vehicle vehicle) {
    	if(isOccupied || !vehicle.getType().equals(vehicleTypeAllowed)) return false;
    	isOccupied = true;
        bookingLog = "Occupied by " + vehicle.vehicleNumber;
        return true;
    }

    public void vacateSlot() {
        isOccupied = false;
        bookingLog = "Empty";
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void showLog() {
        System.out.println(slotId + " " + location + " " + bookingLog);
    }
}