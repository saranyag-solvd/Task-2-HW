package com.solvd.travelagency;

import com.solvd.travelagency.enums.PaymentMethod;
import com.solvd.travelagency.interfaces.IPrintInfo;

public class Payment implements IPrintInfo {
    private PaymentMethod paymentMethod;
    private String confirmationNumber;
    private double amount;

    public Payment(PaymentMethod paymentMethod, String confirmationNumber, double amount) {
        this.paymentMethod = paymentMethod;
        this.confirmationNumber = confirmationNumber;
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
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

    @Override
    public void printDetails() {
        System.out.println("Payment{ paymentMethod=" + paymentMethod + ", confirmationNumber=" + confirmationNumber + ", amount=" + amount + "}");
    }
}