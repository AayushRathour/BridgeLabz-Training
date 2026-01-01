package com.objectmodelling.level1.HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private List<Doctor> doctors;

    // constructor
    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Method to add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // method to return name
    public String getName() {
        return name;
    }

    // List all doctors
    public void listDoctors() {
        for (Doctor d : doctors) {
            System.out.println(d.name + " ");
        }
    }
}