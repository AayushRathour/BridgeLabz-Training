package com.SmartHomeAutomationSystem;

public class Light extends Device {
    public Light(int deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }
}