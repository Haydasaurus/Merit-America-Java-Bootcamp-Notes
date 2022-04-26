package com.techelevator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private String hireDate;
    private static final double STARTING_SALARY = 60_000;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }
    //needed to MAKE this a string, that way it can be called
    public String getSalaryString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(salary);
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Employee(long employeeID, String firstName, String lastName, String email, Department department, String hireDate) {
        this.employeeId = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
        salary = STARTING_SALARY;

    }

    public Employee() {
        salary = STARTING_SALARY;
    }

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public void raiseSalary(double percent) {
        double percentageAmount = salary * percent;
        salary = salary + percentageAmount;
    }



}
