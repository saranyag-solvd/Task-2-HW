package com.solvd.travelagency;

import com.solvd.travelagency.enums.Department;

public class Employee extends Person {
    private int employeeId;
    private Department department;
    private long salary;

    public Employee(String name, int age, Address address, int employeeId, Department department, long salary) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartmentNumber(Department department) {
        this.department = department;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEmployeeDetails() {
        return "Employee Details: Employee{" +
                "employeeId=" + employeeId +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}