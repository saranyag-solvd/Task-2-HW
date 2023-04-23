package com.solvd.travelagency;

public final class Status {
    public static final String booked = "BOOKED";
    public static final String confirmed = "CONFIRMED";
    public static final String cancelled = "CANCELLED";

    static {
        System.out.println("Inside static block in Status");
    }

    public final void printAvailableStatus(){
        System.out.println("Available Statuses :" + this);
    }

    @Override
    public String toString() {
        return "Status{" +
                "booked='" + booked + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", cancelled='" + cancelled + '\'' +
                '}';
    }
}
