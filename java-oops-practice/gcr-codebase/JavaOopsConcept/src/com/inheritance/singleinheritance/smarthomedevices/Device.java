package com.inheritance.singleinheritance.smarthomedevices;

class Device {
    int deviceId;
    String status;

    // constructor
    public Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // method to display
    public void displayStatus() {
        System.out.println(deviceId + " | " + status);
    }
}