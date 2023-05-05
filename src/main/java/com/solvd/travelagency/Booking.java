package com.solvd.travelagency;

import com.solvd.travelagency.exceptions.BookingException;
import com.solvd.travelagency.interfaces.IBookingOperation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Booking implements IBookingOperation {
    private String bookingId;
    private Date date;
    private Customer customer;
    private Map<String, Reservation> reservations;
    private Payment payment;

    public Booking(String bookingId, Date date, Customer customer, Payment payment) {
        this.bookingId = bookingId;
        this.date = date;
        this.customer = customer;
        this.reservations = new HashMap<>();
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

    public Map<String, Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(Map<String, Reservation> reservations) {
        this.reservations = reservations;
    }


    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void createBooking() {
        for (String key : this.reservations.keySet()) {
            this.reservations.get(key).createReservation();
        }
        System.out.println("Booking created");
    }

    public void updateCustomerPhoneNumber(String phoneNumber) {
        this.customer.setPhoneNumber(phoneNumber);
    }

    @Override
    public void cancelBooking() throws BookingException {
        if (this.reservations == null || this.reservations.size() == 0) {
            throw new BookingException("No reservation found to cancel");
        }

        for (String key : this.reservations.keySet()) {
            this.reservations.get(key).cancelReservation();
        }
        System.out.println("Booking cancelled");
    }

    @Override
    public void viewBooking() {
        System.out.println("Booking Details :" + this);
    }

    public void addReservation(String key, Reservation reservation) {

        this.reservations.put(key, reservation);
    }

    public void printInvoice() {
        Util.printFile(this.bookingId);
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
