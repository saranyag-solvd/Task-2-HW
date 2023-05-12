package com.solvd.travelagency.enums;

public enum PaymentMethod {

    CREDIT(0, "Credit Card"),
    DEBIT(1, "Debit Card"),
    CASH(2, "Cash"),
    CHECK(3, "Check");

    private int id;
    private String description;

    PaymentMethod(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
