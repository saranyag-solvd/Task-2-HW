package com.solvd.travelagency;

public class Hotel {
    private String name;
    private Address address;
    private String roomNumber;

    public Hotel(String name, Address address, String roomNumber) {
        this.name = name;
        this.address = address;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void printHotelDetails() {
        System.out.println("Hotel Details :" + this);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", address=" + address.getAddress() +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
