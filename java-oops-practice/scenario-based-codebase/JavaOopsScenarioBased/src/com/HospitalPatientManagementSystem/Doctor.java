package com.HospitalPatientManagementSystem;

public class Doctor {
    private int doctorId;
    private String name;
    private String department;

    public Doctor(int doctorId, String name, String department) {
        this.doctorId = doctorId;
        this.name = name;
        this.department = department;
    }

    public void displayInfo() {
        System.out.println("Doctor Id : " + doctorId + " Name : " + name + " Dept : " + department);
    }
}