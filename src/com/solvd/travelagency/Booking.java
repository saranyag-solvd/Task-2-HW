package com.solvd.travelagency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {
    private String bookingId;
    private Date date;
    private Customer customer;
    private List<Reservation> reservations;
    private Payment payment;

    public Booking(String bookingId, Date date, Customer customer, Payment payment) {
        this.bookingId = bookingId;
        this.date = date;
        this.customer = customer;
        this.reservations = new ArrayList<>();
        this.payment = payment;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    // public void setReservations(List<Reservation> reservations) {
    //    this.reservations = reservations;
    //}


    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void createBooking() {
        for (int i = 0; i < this.reservations.size(); i++) {
            this.reservations.get(i).createReservation();
        }
        System.out.println("Booking created");
    }

    public void updateCustomerPhoneNumber(String phoneNumber) {
        this.customer.setPhoneNumber(phoneNumber);
    }

    public void cancelBooking() {
        for (int i = 0; i < this.reservations.size(); i++) {
            this.reservations.get(i).cancelReservation();
        }

        System.out.println("Booking cancelled");
    }

    public void viewBooking() {
        System.out.println("Booking Details :" + this);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                ", reservations=" + reservations +
                ", payment=" + payment +
                '}';
    }
}
