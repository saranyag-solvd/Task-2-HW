package com.solvd.travelagency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static void printAvailableStatuses() {
        Status status = new Status();
        status.printAvailableStatus();
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date getDateFromStr(String dateStr) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return date;
    }

    public static void test() {
        try {
            Address custAddress = new Address("123 main st", "New York", "NY", "15632", "USA");
            System.out.println("Customer Address :" + custAddress.getAddress());
            int i = 1 / 0;
            Customer customer1 = new Customer("John Doe", 22, custAddress, 1, "123-456-7890", "customer1@test.com");
            System.out.println("Customer Details :" + customer1.getCustomerDetails());
            Customer customer2 = new Customer("Mike Doe", 18, custAddress, 2, "987-654-4321", "customer2@test.com");
            System.out.println("---------------");

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Util.test();
    }
}
