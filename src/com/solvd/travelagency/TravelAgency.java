package com.solvd.travelagency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelAgency {

    public static void main(String[] args) {

        //Create Payment
        Payment ccPayment = new Payment("CreditCard", "c-1234", 178.90);
        ccPayment.printPaymentDetails();
        System.out.println("---------------");

        //Create Customer
        Address custAddress = new Address("123 main st", "New York", "NY", "15632", "USA");
        System.out.println("Customer Address :" + custAddress.getAddress());
        Customer bookingCustomer = new Customer("John Doe", 22, custAddress, 1, "123-456-7890", "bookingCustomer@test.com");
        System.out.println("Customer Details :" + bookingCustomer.getCustomerDetails());
        System.out.println("---------------");

        //Create Employee
        Address empAddress = new Address("123 main st", "New York", "NY", "15632", "USA");
        System.out.println("Employee Address :" + empAddress.getAddress());
        Employee agent = new Employee("Adam Smith", 47, empAddress, 101, 2, 679384);
        System.out.println("Employee Details :" + agent.getEmployeeDetails());
        System.out.println("---------------");

        //Create Reservations
        List<Reservation> reservations = new ArrayList<>();

        //hotel reservation
        Address hotelAddress = new Address("999 Boston st", "Chicago", "IL", "87343", "USA");
        System.out.println("Hotel Address :" + hotelAddress.getAddress());
        Hotel hotel = new Hotel("Marriot", hotelAddress, "43B");
        hotel.printHotelDetails();
        HotelReservation hotelReservation = new HotelReservation("hr-8765", "Booked", new Date(), new Date(), 589.65, "Suite", 4, hotel, "Swimming pool, gym");
        hotelReservation.createReservation();
        hotelReservation.viewReservation();
        hotelReservation.updateReservation();
        hotelReservation.cancelReservation();
        hotelReservation.checkIn();
        System.out.println("---------------");

        // car reservation
        List<Customer> drivers = new ArrayList<>();
        drivers.add(bookingCustomer);
        //CarReservation(String reservationId, String status, Date fromDate, Date toDate, double amount, String carType, List<Customer> drivers, String carDetails)
        CarReservation carReservation = new CarReservation("cr-676334", "Booked", new Date(), new Date(), 762.85, "suv", drivers, "7seaters");
        carReservation.createReservation();
        carReservation.viewReservation();
        carReservation.updateReservation();
        carReservation.cancelReservation();
        carReservation.updateDrivers();
        System.out.println("---------------");

        // flight reservation
        Flight flight = new Flight("F0145", "Logan International", "JFK", "F26");
        flight.printFlightDetails();
        List<Customer> passengers = new ArrayList<>();
        passengers.add(bookingCustomer);

        Itinerary flightReservation = new Itinerary("Fr-1388", "Booked", new Date(), new Date(), 800.00, 1234567, flight, passengers);
        flightReservation.createReservation();
        flightReservation.viewReservation();
        flightReservation.updateReservation();
        flightReservation.cancelReservation();
        flightReservation.updatePassengers();
        System.out.println("---------------");

        // add reservations
        reservations.add(hotelReservation);
        reservations.add(carReservation);
        reservations.add(flightReservation);

        // Create Booking
        Booking booking = new Booking("b-3456", new Date(), bookingCustomer, reservations, ccPayment);
        booking.createBooking();
        booking.viewBooking();
        booking.updateBooking();
        booking.cancelBooking();


    }
}