package com.solvd.travelagency;

import java.util.Objects;

public class Customer extends Person {
    private int customerId;
    private String phoneNumber;
    private String emailAddress;

    public Customer(String name, int age, Address address, int customerId, String phoneNumber, String emailAddress) {
        super(name, age, address);
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCustomerDetails() {
        return "Customer Details :" + this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
