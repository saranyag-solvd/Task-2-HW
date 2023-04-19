package com.solvd.travelagency;

import java.util.Date;
import java.util.List;

public class CarReservation extends Reservation {
    public CarReservation() {

    }

    public CarReservation(String carType, List<Customer> drivers, String carDetails) {
        this.carType = carType;
        this.drivers = drivers;
        this.carDetails = carDetails;
    }

    public CarReservation(String reservationId, String status, Date fromDate, Date toDate, double amount, String carType, List<Customer> drivers, String carDetails) {
        super(reservationId, status, fromDate, toDate, amount);
        this.carType = carType;
        this.drivers = drivers;
        this.carDetails = carDetails;


    }

    private String carType;
    private List<Customer> drivers;
    private String carDetails;

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public List<Customer> getDrivers() {
        return this.drivers;
    }

    public void setDrivers(List<Customer> drivers) {
        this.drivers = drivers;
    }

    public String getCarDetails() {
        return this.carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

    public void updateDrivers() {
        System.out.println("Updated drivers");
    }

    @Override
    public void createReservation() {
        System.out.println("Car reservation created");
    }

    @Override
    public void viewReservation() {
        System.out.println("Car reservationId:" + super.getReservationId());
    }


    public void updateReservation(String carType) {
        updateCarType(carType);
        System.out.println("Car reservation updated");
    }

    private void updateCarType(String carType) {
        this.setCarType(carType);
    }


    @Override
    public void cancelReservation() {
        this.setStatus("cancelled");
        System.out.println("car reservation cancelled");
    }
}
