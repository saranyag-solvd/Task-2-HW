package com.solvd.travelagency;

import com.solvd.travelagency.exceptions.AdminException;

public interface IAdminOperation {
    void recruitEmployee(TravelAgency agency, Employee employee);

    void changeSalary(Employee employee, long newSalary) throws AdminException;

}

