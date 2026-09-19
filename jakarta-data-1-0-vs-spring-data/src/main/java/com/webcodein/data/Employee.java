package com.webcodein.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String department;
    private double salary;
    private boolean active;

    protected Employee() {
    }

    public Employee(Long id, String lastName, String department, double salary, boolean isActive) {
        this.id = id;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.active = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }
}
