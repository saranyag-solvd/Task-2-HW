package com.solvd.travelagency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FlightReservation extends Reservation {
    private long pnrNumber;
    private Flight flight;
    private List<Customer> passengers;

    public FlightReservation(String reservationId, String status, Date fromDate, Date toDate, double amount, long pnrNumber, Flight flight) {
        super(reservationId, status, fromDate, toDate, amount);
        this.pnrNumber = pnrNumber;
        this.flight = flight;
        this.passengers = new ArrayList<>();
    }

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

    @Override
    public void createReservation() {
        super.setStatus(Status.CONFIRMED);
        System.out.println("Flight reservation created");
    }

    @Override
    public void viewReservation() {
        System.out.println("Flight Reservation Details:");
        System.out.println(super.toString());
        System.out.println(this);
    }

    public void updateSeatNumber(String seatNumber) {
        this.flight.setSeatNumber(seatNumber);
        System.out.println("Flight seat number updated");
    }

    @Override
    public void cancelReservation() {
        super.setStatus(Status.CANCELLED);
        System.out.println("Flight reservation cancelled");
    }

    public void addPassenger(Customer passenger) {
        this.passengers.add(passenger);
        System.out.println("passenger added");
    }

    public void removePassenger(Customer passenger) {
        this.passengers.remove(passenger);
        System.out.println("passenger removed");
    }

    @Override
    public String toString() {
        return "FlightReservation{" +
                "pnrNumber=" + pnrNumber +
                ", flight=" + flight +
                ", passengers=" + passengers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightReservation that = (FlightReservation) o;
        return getPnrNumber() == that.getPnrNumber() && Objects.equals(getReservationId(), that.getReservationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPnrNumber(), getReservationId());
    }
}
