package com.SmartHomeAutomationSystem;

public abstract class Device implements Controllable {
    protected int deviceId;
    protected String deviceName;
    protected boolean status;

    public Device(int deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.status = false;
    }

    public boolean getStatus() {
        return status;
    }
}