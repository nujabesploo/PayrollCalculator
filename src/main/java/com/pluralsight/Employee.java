package com.pluralsight;

/**
 * Employee class represents an employee in the system with their basic information and pay details.
 * This class encapsulates employee data and provides getter methods for accessing the information.
 */
public class Employee {

    // Unique identifier for each employee
    private int employeeId;

    // Full name of the employee
    private String name;

    // Number of hours the employee has worked
    private double hoursWorked;

    // Employee's hourly pay rate
    private double payRate;

    /**
     * Constructor to create a new Employee object with all required fields.
     *
     * @param employeeId   Unique identifier for the employee
     * @param name         Employee's full name
     * @param hoursWorked  Number of hours worked by the employee
     * @param payRate      Employee's hourly pay rate
     */
    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.name = name;
    }

    /**
     * @return The unique employee ID
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @return The employee's full name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The number of hours worked by the employee
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @return The employee's hourly pay rate
     */
    public double getPayRate() {
        return payRate;
    }
}
