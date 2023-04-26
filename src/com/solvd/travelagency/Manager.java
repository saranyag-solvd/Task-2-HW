package com.solvd.travelagency;

import java.util.List;

public class Manager extends Employee implements IAdminOperation {

    public Manager(String name, int age, Address address, int employeeId, int departmentNumber, long salary) {
        super(name, age, address, employeeId, departmentNumber, salary);
    }

    @Override
    public void recruitEmployee(List<Employee> employees, Employee employee) {
        employees.add(employee);
        System.out.println("Employee " + employee.getEmployeeId() + " recruited");
    }

    @Override
    public void changeSalary(List<Employee> employees, int employeeId, long newSalary) {
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            if (emp.getEmployeeId() == employeeId) {
                emp.setSalary(newSalary);
                System.out.println("Employee " + employeeId + " Salary updated to " + newSalary);
            }
        }
    }
}
