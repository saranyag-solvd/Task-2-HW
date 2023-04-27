package com.solvd.travelagency;

public class Manager extends Employee implements IAdminOperation {

    public Manager(String name, int age, Address address, int employeeId, int departmentNumber, long salary) {
        super(name, age, address, employeeId, departmentNumber, salary);
    }

    @Override
    public void recruitEmployee(TravelAgency agency, Employee employee) {
        agency.getEmployees().add(employee);

    }

    @Override
    public void changeSalary(Employee employee, long newSalary) {
        employee.setSalary(newSalary);
        System.out.println("Employee " + employee.getEmployeeId() + " Salary updated to " + newSalary);
    }
}
