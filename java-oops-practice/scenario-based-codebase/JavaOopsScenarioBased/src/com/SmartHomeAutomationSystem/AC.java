package com.SmartHomeAutomationSystem;

public class AC extends Device {
    private int temperature;

    public AC(int deviceId, String deviceName) {
        super(deviceId, deviceName);
        this.temperature = 30;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
        System.out.println(deviceName + " AC is OFF");
    }
}