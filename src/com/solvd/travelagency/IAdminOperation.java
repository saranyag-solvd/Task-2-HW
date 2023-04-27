package com.solvd.travelagency;

public interface IAdminOperation {
    void recruitEmployee(TravelAgency agency, Employee employee);

    void changeSalary(Employee employee, long newSalary);

}

