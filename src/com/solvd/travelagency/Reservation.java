package com.solvd.travelagency;

import java.util.Date;

public abstract class Reservation {
    private String reservationId;
    private String status;
    private Date fromDate;
    private Date toDate;
    private double amount;

    public Reservation(String reservationId, String status, Date fromDate, Date toDate, double amount) {
        this.reservationId = reservationId;
        this.status = status;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.amount = amount;
    }

    public String getReservationId() {
        return this.reservationId;
    }

    protected void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getStatus() {
        return this.status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    protected void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    protected void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getAmount() {
        return this.amount;
    }

    protected void setAmount(double amount) {
        this.amount = amount;
    }

    protected abstract void createReservation();

    protected abstract void viewReservation();

    protected abstract void cancelReservation();

    @Override
    public String toString() {
        return "reservationId='" + reservationId + '\'' +
                ", status='" + status + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", amount=" + amount;
    }
}
