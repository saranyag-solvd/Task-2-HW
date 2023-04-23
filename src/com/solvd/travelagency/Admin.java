package com.solvd.travelagency;

import java.util.ArrayList;
import java.util.List;

public class Admin implements IAdminOperation {
    private List<Employee> employees;

    public Admin() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void recruitEmployee(Employee employees) {
        this.employees.add(employees);
        System.out.println("Employee added");
    }


    @Override
    public void changeSalary(int employeeId) {
        for (int i = 0; i < this.employees.size(); i++) {
            Employee emp = this.employees.get(i);
            if (emp.getEmployeeId() == employeeId) {
                emp.setSalary(emp.getSalary() + 5000);
            }


        }
    }
}
