package com.solvd.travelagency;

public class Flight implements ICheckIn,IPrintInfo{
    private String flightNumber;
    private String arrivalAirport;
    private String destinationAirport;
    private String seatNumber;

    public Flight(String flightNumber, String arrivalAirport, String destinationAirport, String seatNumber) {
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrivalAirport;
        this.destinationAirport = destinationAirport;
        this.seatNumber = seatNumber;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrivalAirport() {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDestinationAirport() {
        return this.destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }



    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }

    @Override
    public void checkIn() {
        System.out.println("Checked into Flight");
    }

    @Override
    public void allowIn() {
        System.out.println("Allowed inside Aircraft");
    }

    @Override
    public void printDetails() {
        System.out.println("Printing Flight Details :" + this);
    }
}
