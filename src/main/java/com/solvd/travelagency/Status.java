package com.solvd.travelagency;

public final class Status {
    public static final String BOOKED = "BOOKED";
    public static final String CONFIRMED = "CONFIRMED";
    public static final String CANCELLED = "CANCELLED";

    static {
        System.out.println("Inside static block in Status");
    }

    public final void printAvailableStatus() {
        System.out.println("Available Statuses :" + this);
    }

    @Override
    public String toString() {
        return "Status{" +
                "BOOKED='" + BOOKED + '\'' +
                ", CONFIRMED='" + CONFIRMED + '\'' +
                ", CANCELLED='" + CANCELLED + '\'' +
                '}';
    }
}
