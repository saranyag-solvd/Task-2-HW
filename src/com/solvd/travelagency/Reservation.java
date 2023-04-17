package com.solvd.travelagency;

import java.util.Date;

public class Reservation {

    public Reservation() {

    }

    public Reservation(String reservationId, String status, Date fromDate, Date toDate, double amount) {
        this.reservationId = reservationId;
        this.status = status;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.amount = amount;
    }

    private String reservationId;
    private String status;
    private Date fromDate;
    private Date toDate;
    private double amount;

    public String getReservationId() {
        return this.reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void createReservation() {
        System.out.println("reservation created");
    }

    public void viewReservation() {
        System.out.println("reservationId:" + this.reservationId + " status:" + this.status);
    }

    public void updateReservation() {
        System.out.println("reservation updated");
    }

    public void cancelReservation() {
        System.out.println("reservation cancel");
    }

    public void checkIn() {
        System.out.println("Customer checkedIn");
    }


}
