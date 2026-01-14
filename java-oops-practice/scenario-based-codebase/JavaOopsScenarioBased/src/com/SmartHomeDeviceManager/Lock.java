package com.SmartHomeDeviceManager;

public class Lock extends Device {

    Lock(int id, double usage) {
        super(id, usage);
    }

    public void turnOn() {
        setStatus(true);
    }

    public void turnOff() {
        setStatus(false);
    }

    public void reset() {
        firmwareLog = "Lock reset completed";
        setStatus(false);
    }
}