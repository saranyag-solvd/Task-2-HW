package com.solvd.travelagency;

import com.solvd.travelagency.exceptions.TravelAgencyException;

import java.util.*;

public final class TravelAgency {
    private String travelAgencyName;
    private ArrayList<Customer> customers;

//    private ArrayList<Booking> bookings;
    private Map<String, Booking> bookings;
    private CustomLinkedList<Employee> employees;
    private ArrayList<Hotel> hotels;
    private Set<Flight> flights;

    public TravelAgency(String travelAgencyName) {
        this.travelAgencyName = travelAgencyName;
        this.customers = new ArrayList<Customer>();
        this.bookings = new HashMap<>();
        this.employees = new CustomLinkedList<>();
        this.hotels = new ArrayList<Hotel>();
        this.flights = new HashSet<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public CustomLinkedList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public Set<Flight> getFlights() {
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

    public void addManager(Employee manager) {
        employees.addFirst(manager);
    }

    public void printEmployees() {
        employees.show();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
    }

    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void removeEmployee(Employee employee) {
        //employees.remove(employee);
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
        bookings.put(booking.getBookingId(), booking);
    }

    public void printBookings() {
//        for (Booking booking : bookings.values()) {
//            System.out.println(booking);
//        }
        for (Map.Entry<String,Booking> entry : bookings.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }

    }

    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println("Flight :" + flight);
        }

    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

}
