package com.objectmodelling.level1.HospitalManagementSystem;

import java.util.ArrayList;

public class Doctor {
    String name;
    ArrayList<Patient> patients;

    // constructor
    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    // Method to add a patient
    public void addPatient(Patient patient) {
    	patients.add(patient);
    	patient.addDoctor(this);
    }

    // Method to consult a patient
    public void consult(Patient patient) {
        System.out.println(name + " is consulting patient " + patient.getName());
    }

    // List all patients
    public void listPatients() {
        for (Patient p : patients) {
            System.out.println(p.getName() + " ");
        }
    }

}