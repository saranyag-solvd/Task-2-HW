package com.solvd.travelagency;

import com.solvd.travelagency.exceptions.TravelAgencyException;

import java.util.ArrayList;

public final class TravelAgency {
    private String travelAgencyName;
    private ArrayList<Customer> customers;

    private ArrayList<Booking> bookings;
    private ArrayList<Employee> employees;
    private ArrayList<Hotel> hotels;
    private ArrayList<Flight> flights;

    public TravelAgency(String travelAgencyName) {
        this.travelAgencyName = travelAgencyName;
        this.customers = new ArrayList<Customer>();
        this.bookings = new ArrayList<Booking>();
        this.employees = new ArrayList<Employee>();
        this.hotels = new ArrayList<Hotel>();
        this.flights = new ArrayList<Flight>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public String getTravelAgencyName() {
        return travelAgencyName;
    }

    public void setTravelAgencyName(String travelAgencyName) {
        this.travelAgencyName = travelAgencyName;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addEmployee(Employee employee) throws TravelAgencyException {
        if (employee == null) {
            throw new TravelAgencyException("Invalid Employee");
        }
        employees.add(employee);

    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }


    public void addHotels(Hotel hotel) {
        hotels.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);

    }

    public void addFlight(Flight flight) {
        flights.add(flight);

    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void printBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

}
