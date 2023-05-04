package com.solvd.travelagency.interfaces;

import com.solvd.travelagency.Employee;
import com.solvd.travelagency.TravelAgency;
import com.solvd.travelagency.exceptions.AdminException;

public interface IAdminOperation {
    void recruitEmployee(TravelAgency agency, Employee employee);

    void changeSalary(Employee employee, long newSalary) throws AdminException;

}

