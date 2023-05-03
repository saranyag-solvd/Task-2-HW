package com.solvd.travelagency;

import com.solvd.travelagency.exceptions.AdminException;
import com.solvd.travelagency.exceptions.TravelAgencyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Manager extends Employee implements IAdminOperation {
    private static final Logger LOGGER = LogManager.getLogger(Manager.class);

    public Manager(String name, int age, Address address, int employeeId, int departmentNumber, long salary) {
        super(name, age, address, employeeId, departmentNumber, salary);
    }

    @Override
    public void recruitEmployee(TravelAgency agency, Employee employee) {
        try {
            agency.addEmployee(employee);
        } catch (TravelAgencyException e) {
            LOGGER.error("Unable to recruit employee : " + e);
        }
    }

    @Override
    public void changeSalary(Employee employee, long newSalary) throws AdminException {
        if (employee == null) {
            throw new AdminException("No employee found to change salary");
        }
        if (newSalary < 0 || employee.getSalary() == newSalary) { // if Negative salary or same salary
            throw new AdminException("Invalid Salary");
        }
        employee.setSalary(newSalary);
        System.out.println("Employee " + employee.getEmployeeId() + " Salary updated to " + newSalary);
    }
}
