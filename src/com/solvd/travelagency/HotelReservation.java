package com.solvd.travelagency;

import java.util.Date;

public class HotelReservation extends Reservation {

    public HotelReservation() {

    }

    public HotelReservation(String roomType, int noOfGuest, Hotel hotel, String amenities) {
        this.roomType = roomType;
        this.noOfGuest = noOfGuest;
        this.hotel = hotel;
        this.amenities = amenities;
    }

    public HotelReservation(String reservationId, String status, Date fromDate, Date toDate, double amount, String roomType, int noOfGuest, Hotel hotel, String amenities) {
        super(reservationId, status, fromDate, toDate, amount);
        this.roomType = roomType;
        this.noOfGuest = noOfGuest;
        this.hotel = hotel;
        this.amenities = amenities;
    }

    private String roomType;
    private int noOfGuest;
    private Hotel hotel;
    private String amenities;

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
        System.out.println("Hotel reservation created");
    }

    @Override
    public void viewReservation() {
        System.out.println("Hotel Reservation ID :" + this.getReservationId());
    }

    @Override
    public void updateReservation() {
        System.out.println("Hotel reservation updated");
    }

    @Override
    public void cancelReservation() {
        System.out.println("Hotel reservation cancelled");
    }
}
