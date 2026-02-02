package com.Collectors.categorizesalary;

public class Employee {
    String department;
    double salary;

    public Employee(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
