package com.solvd.travelagency;

import java.util.Date;
import java.util.Objects;

public class HotelReservation extends Reservation {
    private String roomType;
    private int noOfGuest;
    private Hotel hotel;
    private String amenities;

    public HotelReservation(String reservationId, String status, Date fromDate, Date toDate, double amount, String roomType, int noOfGuest, Hotel hotel, String amenities) {
        super(reservationId, status, fromDate, toDate, amount);
        this.roomType = roomType;
        this.noOfGuest = noOfGuest;
        this.hotel = hotel;
        this.amenities = amenities;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNoOfGuest() {
        return this.noOfGuest;
    }

    public void setNoOfGuest(int noOfGuest) {
        this.noOfGuest = noOfGuest;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getAmenities() {
        return this.amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    @Override
    public void createReservation() {
        super.setStatus("Confirmed");
        System.out.println("Hotel reservation created");
    }

    @Override
    public void viewReservation() {
        System.out.println("Hotel Reservation Details:");
        System.out.println(super.toString());
        System.out.println(this);
    }

    public void updateGuest(int noOfGuest) {
        this.setNoOfGuest(noOfGuest);
        System.out.println("Hotel no.of Guests updated");
    }

    @Override
    public void cancelReservation() {
        super.setStatus("Cancelled");
        System.out.println("Hotel reservation cancelled");
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "roomType='" + roomType + '\'' +
                ", noOfGuest=" + noOfGuest +
                ", hotel=" + hotel +
                ", amenities='" + amenities + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelReservation that = (HotelReservation) o;
        return Objects.equals(getRoomType(), that.getRoomType()) && Objects.equals(getReservationId(), that.getReservationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomType(), getReservationId());
    }
}
