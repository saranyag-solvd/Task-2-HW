package com.solvd.travelagency;

import java.util.Date;
import java.util.List;

public class Booking {
    public Booking(){

    }
    public Booking(String bookingId, Date date, Customer customer, List<Reservation> reservations, Payment payment){
        this.bookingId = bookingId;
        this.date = date;
        this.customer = customer;
        this.reservations = reservations;
        this.payment = payment;
    }
    private String bookingId;
    private Date date;
    private Customer customer;
    private List<Reservation> reservations;
    private Payment payment;

    public String getBookingId(){
        return this.bookingId;
    }
    public void setBookingId(String bookingId){
        this.bookingId = bookingId;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public List<Reservation> getReservations(){
        return this.reservations;
    }
    public void setReservations(List<Reservation> reservations){
        this.reservations = reservations;
    }
    public Payment getPayment(){
        return this.payment;
    }
    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public void createBooking(){
        System.out.println("Booking created");
    }

    public void updateBooking(){
        this.getCustomer().setPhoneNumber("515-650-1245");

        System.out.println("Booking updated");
    }

    public void cancelBooking(){
        for(int i = 0; i<this.reservations.size(); i++){
            this.reservations.get(i).cancelReservation();
        }

        System.out.println("Booking cancelled");
    }

    public void viewBooking(){
        System.out.println("bookingId :" +this.bookingId);
    }
}
