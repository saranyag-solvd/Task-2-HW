package com.solvd.travelagency;


import com.solvd.travelagency.enums.*;
import com.solvd.travelagency.exceptions.AdminException;
import com.solvd.travelagency.exceptions.BookingException;
import com.solvd.travelagency.exceptions.PassengerException;
import com.solvd.travelagency.interfaces.IDetails;
import com.solvd.travelagency.interfaces.IPrint;
import com.solvd.travelagency.interfaces.ISearch;
import com.solvd.travelagency.thread.ConnectionExecutor;
import com.solvd.travelagency.thread.ThreadUsingRunnable;
import com.solvd.travelagency.thread.ThreadUsingThread;
import com.solvd.travelagency.utils.ReflectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Create Manager
        Address mgrAddress = new Address("26 grove st", "Boston", "MA", "01233", "USA");
        LOGGER.debug("Manager Address :" + mgrAddress.getAddress());
        Manager manager = new Manager("Sam Adams", 47, mgrAddress, 1, 120000);
        LOGGER.debug("Manager Details :" + manager.getEmployeeDetails());

        //Create Employees
        Address empAddress = new Address("12 robert st", "Hartford", "CT", "34343", "USA");
        LOGGER.debug("Employee Address :" + empAddress.getAddress());
        Employee emp1 = new Employee("Adam Smith", 37, empAddress, 101, Department.TRAVEL_AGENT, 50000);
        Employee emp2 = new Employee("Rick Smith", 19, empAddress, 102, Department.HELPDESK, 40000);
        Employee emp3 = new Employee("Jane Smith", 31, empAddress, 103, Department.TRAVEL_AGENT, 48000);
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
        Payment ccPayment = new Payment(PaymentMethod.CREDIT, "c-1234", 178.90);
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
        HotelReservation hotelReservation = new HotelReservation("hr-8765", Status.BOOKED, Util.getDateFromStr("05/13/2023"), Util.getDateFromStr("05/17/2023"), 589.65, RoomType.SUITE, 4, hotel, "Swimming pool, gym");
        hotelReservation.createReservation();
        hotelReservation.updateGuest(5);
        hotelReservation.viewReservation();
        hotelReservation.cancelReservation();
        LOGGER.debug("---------------");

        // car reservation
        CarReservation carReservation = new CarReservation("cr-676334", Status.BOOKED, Util.getDateFromStr("05/13/2023"), Util.getDateFromStr("05/17/2023"), 400.50, CarType.SUV, "7seaters");
        carReservation.addDriver(customer1);
        carReservation.addDriver(customer2);
//        carReservation.removeDriver(customer2);
        carReservation.createReservation();
        carReservation.updateCarType(CarType.SEDAN);
        carReservation.viewReservation();
        carReservation.cancelReservation();

        CarReservation carReservation2 = new CarReservation("cr-676334", Status.BOOKED, Util.getDateFromStr("05/23/2023"), Util.getDateFromStr("05/29/2023"), 900.0, CarType.SEDAN, "electric");
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
        booking.addReservation(ReservationType.HOTEL.getDescription(), hotelReservation);
        booking.addReservation(ReservationType.CAR.getDescription(), carReservation);
        booking.addReservation(ReservationType.FLIGHT.getDescription(), flightReservation);
        LOGGER.debug("Reservations :" + booking.getReservations());

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

        //Add manager
        agency.addManager(manager);

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
        booking.printInvoice();

        LOGGER.debug("---------------### StringUtil & FileUtil ###---------------");
        //StringUtil & FileUtil
        Util.uniqueWords("src/main/resources/input.txt", "output.txt");
        LOGGER.debug("---------------");

        LOGGER.debug("---------------### Lambda using java.util.function ###---------------");
        //Lambda using java.util.function
        Consumer<Employee> c1 = emp -> LOGGER.debug("Employee salary is:" + emp.getSalary());
        c1.accept(emp3);

        LongPredicate lp1 = sal -> sal > 50000;
        LOGGER.debug("Is Employee Salary > 50k ? " + lp1.test(emp3.getSalary()));

        Predicate<Employee> p1 = emp -> emp.getDepartment() == Department.TRAVEL_AGENT;
        LOGGER.debug("Is Employee a Travel Agent ? " + p1.test(emp3));

        Function<Employee, String> f1 = emp -> emp.getDepartment().getName();
        LOGGER.debug("Employee Department Name : " + f1.apply(emp3));

        Supplier<Date> s1 = () -> Util.getCurrentDate();
        LOGGER.debug("Current Date : " + s1.get());
        LOGGER.debug("---------------");

        LOGGER.debug("---------------### Custom Lambda ###---------------");
        //Customer Function interface Lambda
        ISearch<Customer> searchByAge = customer -> customer.getAge() > 18;
        LOGGER.debug("Customer Search by Age result : " + agency.getCustomers(searchByAge));
        ISearch<Customer> searchByName = customer -> customer.getName().contains("Doe");
        LOGGER.debug("Customer Search by Name result : " + agency.getCustomers(searchByName));

        IPrint<Payment> paymentPrint = payment -> payment.printDetails();
        paymentPrint.print(booking.getPayment());
        IPrint<Employee> empPrint = employee -> LOGGER.debug("Employee : " + employee.toString());
        empPrint.print(emp2);

        IDetails<Payment, String> fPaymentMethod = payment -> payment.getPaymentMethod().getDescription();
        LOGGER.debug("Payment method : " + fPaymentMethod.getDetail(booking.getPayment()));
        IDetails<Employee, String> fEmpZip = employee -> employee.getAddress().getZipcode();
        LOGGER.debug("Employee Zip : " + fEmpZip.getDetail(emp2));
        LOGGER.debug("---------------");

        LOGGER.debug("---------------### Streams ###---------------");
        //Stream #1 with non terminal (.filter .map) & terminal (.collect)
        List<String> filteredFlightNumbers = agency.getFlights().stream()
                .filter(flight2 -> flight2.getDestinationAirport().equals("JFK"))
                .map(flight2 -> flight2.getFlightNumber()).collect(Collectors.toList());
        LOGGER.debug("Stream #1 - Filtered Flight Numbers :" + filteredFlightNumbers);

        //Stream #2 with non terminal (.distinct) & terminal (.count)
        long flightCount = agency.getFlights().stream().distinct().count();
        LOGGER.debug("Stream #2 - Flight Count :" + flightCount);

        //Stream #3 with non terminal (.map .sorted) & terminal (.collect)
        List<String> sortedFlightNumbers = agency.getFlights().stream()
                .map(flight2 -> flight2.getFlightNumber()).sorted().collect(Collectors.toList());
        LOGGER.debug("Stream #3 - Sorted Flight Numbers :" + sortedFlightNumbers);

        //Stream #4 with terminal (.anyMatch)
        boolean bostonFlight = agency.getFlights().stream()
                .anyMatch(flight2 -> flight2.getDestinationAirport().equals("BOS"));
        LOGGER.debug("Stream #4 - Flight to BOS :" + bostonFlight);

        //Stream #5 with non terminal (.map) & terminal (.reduce)
        Optional<String> names = agency.getCustomers().stream()
                .map(customer -> customer.getName()).reduce((name1, name2) -> name1 + ", " + name2);
        LOGGER.debug("Stream #5 - Customer Names :" + names);

        //Stream #6 with non terminal (.map) & terminal (.min)
        Optional<Integer> minAge = agency.getCustomers().stream()
                .map(customer -> customer.getAge()).min(Comparator.naturalOrder());
        LOGGER.debug("Stream #6 - Customer Min Age :" + minAge);

        //Stream #7 with non terminal (.limit) & terminal (.count)
        long count = agency.getBookings().stream()
                .limit(1).count();
        LOGGER.debug("Stream #7 - Limited Bookings :" + count);

        LOGGER.debug("---------------");

        LOGGER.debug("---------------### Reflection ###---------------");

        Class clazz = ReflectionUtil.getaClass("com.solvd.travelagency.TravelAgency");

        ReflectionUtil.printMethods(clazz);
        LOGGER.debug("---------------");

        ReflectionUtil.printFields(clazz);
        LOGGER.debug("---------------");

        ReflectionUtil.printConstructors(clazz);
        LOGGER.debug("---------------");

        TravelAgency refAgency = (TravelAgency) ReflectionUtil.instantiateObject(clazz, "NameByReflection");
        LOGGER.debug("Instantiated Agency Name :" + refAgency.getTravelAgencyName());
        LOGGER.debug("---------------");

        ReflectionUtil.invokeMethod(clazz, refAgency, "setTravelAgencyName", "UpdatedNameByReflection");
        LOGGER.debug("Updated Agency Name :" + refAgency.getTravelAgencyName());
        LOGGER.debug("---------------");

        LOGGER.debug("---------------### Threads ###---------------");
        Thread thread1 = new ThreadUsingThread();
        thread1.setName("thread1-ThreadUsingThread");
        thread1.start();

        Thread thread2 = new Thread(new ThreadUsingRunnable());
        thread2.setName("thread2-ThreadUsingRunnable");
        thread2.start();

        ConnectionExecutor executor = new ConnectionExecutor();
        executor.executeThreads();
        executor.executeCompletableFutures();
        executor.executeExecutorService();
    }
}