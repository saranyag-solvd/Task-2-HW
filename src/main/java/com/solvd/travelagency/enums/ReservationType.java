package com.solvd.travelagency.enums;

public enum ReservationType {
    FLIGHT(0, "Flight Reservation"),
    HOTEL(1, "Hotel Reservation"),
    CAR(2, "Car Reservation");

    private int id;
    private String description;

    ReservationType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
