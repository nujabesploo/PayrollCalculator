package com.pluralsight;

public class Employee {

    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;




    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.name = name;

    }


    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId()
    {

        return employeeId;
    }

    public double getGrossPay()
    {
        return hoursWorked * payRate;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }
}
