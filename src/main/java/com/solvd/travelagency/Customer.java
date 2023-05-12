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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() && Objects.equals(getEmailAddress(), customer.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getEmailAddress());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", Name=" + super.getName() +
                ", age=" + super.getAge() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
