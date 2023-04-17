package com.solvd.travelagency;

import java.util.Date;
import java.util.List;

public class Itinerary extends Reservation {
    public Itinerary() {

    }

    public Itinerary(long pnrNumber, Flight flight, List<Customer> passengers) {
        this.pnrNumber = pnrNumber;
        this.flight = flight;
        this.passengers = passengers;
    }

    public Itinerary(String reservationId, String status, Date fromDate, Date toDate, double amount, long pnrNumber, Flight flight, List<Customer> passengers) {
        super(reservationId, status, fromDate, toDate, amount);
        this.pnrNumber = pnrNumber;
        this.flight = flight;
        this.passengers = passengers;
    }

    private long pnrNumber;
    private Flight flight;
    private List<Customer> passengers;

    public long getPnrNumber() {
        return this.pnrNumber;
    }

    public void setPnrNumber(long pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Customer> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(List<Customer> passengers) {
        this.passengers = passengers;
    }

    public void updatePassengers() {
        System.out.println("updated passengers");
    }

    @Override
    public void createReservation() {
        System.out.println("Flight reservation created");
    }

    @Override
    public void viewReservation() {
        System.out.println("Flight reservation Id:" + this.getReservationId());
    }

    @Override
    public void updateReservation() {
        System.out.println("Flight reservation updated");
    }

    @Override
    public void cancelReservation() {
        System.out.println("Flight reservation cancelled");
    }
}
