package com.solvd.travelagency;

public class Hotel implements ICheckIn, ICheckOut, IPrintInfo {
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


    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", address=" + address.getAddress() +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

    @Override
    public void checkIn() {
        System.out.println("Checked in at Hotel Lobby. Room key issued.");
    }

    @Override
    public void allowIn() {
        System.out.println("Allowed into Hotel Room");
    }

    @Override
    public void checkOut() {
        System.out.println("Checked out of Hotel");
    }

    @Override
    public void printDetails() {
        System.out.println("Printing Hotel Details :" + this);
    }
}
