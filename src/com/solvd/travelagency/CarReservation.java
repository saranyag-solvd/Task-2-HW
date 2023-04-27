package com.solvd.travelagency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CarReservation extends Reservation {
    private String carType;
    private List<Customer> drivers;
    private String carDetails;

    public CarReservation(String reservationId, String status, Date fromDate, Date toDate, double amount, String carType, String carDetails) {
        super(reservationId, status, fromDate, toDate, amount);
        this.carType = carType;
        this.drivers = new ArrayList<>();
        this.carDetails = carDetails;
    }

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

    @Override
    public void createReservation() {
        super.setStatus(Status.CONFIRMED);
        System.out.println("Car reservation created");
    }

    @Override
    public void viewReservation() {
        System.out.println("Car Reservation Details:");
        System.out.println(super.toString());
        System.out.println(this);
    }

    public void updateCarType(String carType) {
        this.setCarType(carType);
        System.out.println("Car type updated");
    }

    @Override
    public void cancelReservation() {
        this.setStatus(Status.CANCELLED);
        System.out.println("car reservation cancelled");
    }

    public void addDriver(Customer driver) {
        this.drivers.add(driver);
        System.out.println("Car Driver Added");
    }

    public void removeDriver(Customer driver) {
        this.drivers.remove(driver);
        System.out.println("Car Driver Removed");
    }

    @Override
    public String toString() {
        return "CarReservation{" +
                "carType='" + carType + '\'' +
                ", drivers=" + drivers +
                ", carDetails='" + carDetails + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarReservation that = (CarReservation) o;
        return Objects.equals(getCarType(), that.getCarType()) && Objects.equals(getReservationId(), that.getReservationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarType(), getReservationId());
    }
}
