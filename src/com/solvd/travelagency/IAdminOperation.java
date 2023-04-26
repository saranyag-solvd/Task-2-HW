package com.solvd.travelagency;

import java.util.List;

public interface IAdminOperation {
    void recruitEmployee(List<Employee> employees, Employee employee);

    void changeSalary(List<Employee> employees, int employeeId, long newSalary);

}

