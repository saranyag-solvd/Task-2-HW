package com.solvd.travelagency;

public class Customer extends Person {

    public Customer(){

    }

    public Customer(int customerId, String phoneNumber, String emailAddress){
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Customer(String name, int age, Address address, int customerId, String phoneNumber, String emailAddress){
        super(name, age, address);
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    private int customerId;
    private String phoneNumber;
    private String emailAddress;

    public int getCustomerId(){
        return this.customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
   public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
   }
   public String getEmailAddress(){
        return this.emailAddress;
   }
   public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
   }

   public String getCustomerDetails(){
        return "returning customer details";
   }
}
