package com.solvd.travelagency;


import com.solvd.travelagency.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Create Manager
        Address mgrAddress = new Address("26 grove st", "Boston", "MA", "01233", "USA");
        LOGGER.debug("Manager Address :" + mgrAddress.getAddress());
        Manager manager = new Manager("Sam Adams", 47, mgrAddress, 1, 1, 120000);
        LOGGER.debug("Manager Details :" + manager.getEmployeeDetails());

        //Create Employees
        Address empAddress = new Address("12 robert st", "Hartford", "CT", "34343", "USA");
        LOGGER.debug("Employee Address :" + empAddress.getAddress());
        Employee emp1 = new Employee("Adam Smith", 37, empAddress, 101, 2, 50000);
        Employee emp2 = new Employee("Rick Smith", 19, empAddress, 102, 2, 40000);
        Employee emp3 = new Employee("Jane Smith", 31, empAddress, 103, 2, 48000);
        LOGGER.debug("Employee 1 Details :" + emp1.getEmployeeDetails());
        LOGGER.debug("Employee 2 Details :" + emp2.getEmployeeDetails());
        LOGGER.debug("Employee 3 Details :" + emp3.getEmployeeDetails());
        LOGGER.debug("---------------");

        //Create Customer
        Address custAddress = new Address("123 main st", "New York", "NY", "15632", "USA");
        LOGGER.debug("Customer Address :" + custAddress.getAddress());
        Customer customer1 = new Customer("John Doe", 22, custAddress, 1, "123-456-7890", "customer1@test.com");
        Customer customer2 = new Customer("Mike Doe", 18, custAddress, 2, "987-654-4321", "customer2@test.com");
        LOGGER.debug("Customer 1 Details :" + customer1.getCustomerDetails());
        LOGGER.debug("Customer 2 Details :" + customer2.getCustomerDetails());
        LOGGER.debug("---------------");


        //Create Payment
        Payment ccPayment = new Payment("CreditCard", "c-1234", 178.90);
        ccPayment.printDetails();
        LOGGER.debug("---------------");

        //hotel reservation
        Address hotelAddress = new Address("999 Boston st", "Chicago", "IL", "87343", "USA");
        LOGGER.debug("Hotel Address :" + hotelAddress.getAddress());
        Hotel hotel = new Hotel("Marriot", hotelAddress, "43B");
        hotel.checkIn();
        hotel.allowIn();
        hotel.checkOut();
        hotel.printDetails();
        HotelReservation hotelReservation = new HotelReservation("hr-8765", Status.BOOKED, Util.getDateFromStr("05/13/2023"), Util.getDateFromStr("05/17/2023"), 589.65, "Suite", 4, hotel, "Swimming pool, gym");
        hotelReservation.createReservation();
        hotelReservation.updateGuest(5);
        hotelReservation.viewReservation();
        hotelReservation.cancelReservation();
        LOGGER.debug("---------------");

        // car reservation
        CarReservation carReservation = new CarReservation("cr-676334", Status.BOOKED, Util.getDateFromStr("05/13/2023"), Util.getDateFromStr("05/17/2023"), 400.50, "suv", "7seaters");
        carReservation.addDriver(customer1);
        carReservation.addDriver(customer2);
//        carReservation.removeDriver(customer2);
        carReservation.createReservation();
        carReservation.updateCarType("Sedan");
        carReservation.viewReservation();
        carReservation.cancelReservation();

        CarReservation carReservation2 = new CarReservation("cr-676334", Status.BOOKED, Util.getDateFromStr("05/23/2023"), Util.getDateFromStr("05/29/2023"), 900.0, "Sedan", "electric");
        LOGGER.debug("Car Reservations equal ? " + carReservation.equals(carReservation2));
        LOGGER.debug("---------------");

        // flight reservation
        Flight flight = new Flight("F0145", "Logan International", "JFK", "F26");
        Flight flight1 = new Flight("Q0546", "JFK International", "BOS", "A12");
        flight.checkIn();
        flight.allowIn();
        flight.printDetails();
        FlightReservation flightReservation = new FlightReservation("Fr-1388", Status.BOOKED, Util.getDateFromStr("05/12/2023"), Util.getDateFromStr("05/17/2023"), 800.00, 1234567, flight);
        flightReservation.addPassenger(customer1);
        flightReservation.addPassenger(customer2);
        //Remove passenger exception
        try {
            flightReservation.removePassenger(customer1);
        } catch (PassengerException e) {
            LOGGER.error("Exception:" + e);
        }
        flightReservation.createReservation();
        flightReservation.updateSeatNumber("A35");
        flightReservation.viewReservation();
        flightReservation.cancelReservation();
        LOGGER.debug("---------------");


        // Create Booking
        Booking booking = new Booking("b-0001", Util.getCurrentDate(), customer1, ccPayment);
        Booking booking1 = new Booking("b-0002", Util.getCurrentDate(), customer1, ccPayment);

        // add reservations
        booking.addReservation(hotelReservation);
        booking.addReservation(carReservation);
        booking.addReservation(flightReservation);

        booking.createBooking();
        booking.updateCustomerPhoneNumber("345-435-5869");
        booking.viewBooking();
        // Cancel booking exception handled
        try {
            booking.cancelBooking();
        } catch (BookingException e) {
            LOGGER.error("Exception:" + e);
        }
        LOGGER.debug("---------------");


        //Travel Agency
        TravelAgency agency = new TravelAgency("Global Travels");

        //Add employee
        try {
            agency.addEmployee(manager);
        } catch (TravelAgencyException e) {
            LOGGER.error("Exception:" + e);
        }
        //Recruit employees
        manager.recruitEmployee(agency, emp1);
        manager.recruitEmployee(agency, emp2);
        manager.recruitEmployee(agency, emp3);
        try {
            manager.changeSalary(agency.getEmployees().get(1), 60000);
        } catch (AdminException e) {
            LOGGER.error("Exception :" + e);
        }
        agency.printEmployees();

        //Add flights
        agency.addFlight(flight);
        agency.addFlight(flight1);
        agency.addFlight(flight); // adding duplicate flight
        agency.printFlights();

        //Add hotels
        agency.addHotels(hotel);

        //Add customers
        agency.addCustomer(customer1);
        agency.addCustomer(customer2);
        agency.printCustomers();

        //Add bookings
        agency.addBooking(booking);
        agency.addBooking(booking1);
        agency.printBookings();
        LOGGER.debug("---------------");

        Util.printAvailableStatuses();
        LOGGER.debug("---------------");

        //Exceptions
        try {
            carReservation2.removeDriver(null);
        } catch (DriverException e) {
            LOGGER.error("DriverException : " + e);
        }
        try {
            flightReservation.removePassenger(null);
        } catch (PassengerException e) {
            LOGGER.error("PassengerException : " + e);
        }

        try {
            agency.addEmployee(null);
        } catch (TravelAgencyException e) {
            LOGGER.error("TravelAgencyException :" + e);
        }
        manager.recruitEmployee(agency, null);
        try {
            manager.changeSalary(null, 50000);
        } catch (AdminException e) {
            LOGGER.error("AdminException : " + e);
        }
        try {
            manager.changeSalary(agency.getEmployees().get(1), -1000);
        } catch (AdminException e) {
            LOGGER.error("AdminException : " + e);
        }
        try {
            booking.setReservations(null);
            booking.cancelBooking();
        } catch (BookingException e) {
            LOGGER.error("BookingException : " + e);
        }
        booking.printInvoice();


    }
}