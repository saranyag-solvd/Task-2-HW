package com.solvd.travelagency;

public class Payment {
    private String paymentMethod;
    private String confirmationNumber;
    private double amount;

    public Payment(String paymentMethod, String confirmationNumber, double amount) {
        this.paymentMethod = paymentMethod;
        this.confirmationNumber = confirmationNumber;
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getConfirmationNumber() {
        return this.confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void printPaymentDetails() {
        System.out.println("Payment{ paymentMethod=" + paymentMethod + ", confirmationNumber=" + confirmationNumber + ", amount=" + amount + "}");
    }


}