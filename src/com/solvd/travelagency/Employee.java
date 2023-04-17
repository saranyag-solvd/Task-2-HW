package com.solvd.travelagency;

public class Employee extends Person {

    public Employee() {

    }

    public Employee(int employeeId, int departmentNumber, long salary) {
        this.employeeId = employeeId;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
    }

    public Employee(String name, int age, Address address, int employeeId, int departmentNumber, long salary) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
    }

    private int employeeId;
    private int departmentNumber;
    private long salary;

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentNumber() {
        return this.departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEmployeeDetails() {
        return "returning employee details";
    }


}