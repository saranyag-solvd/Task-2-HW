package com.solvd.travelagency;


//import org.apache.logging.log4j.core.Logger;

public class TravelAgency {
//    private static Logger logger = Logger.getLogger(TravelAgency.class);

    public static void main(String[] args) {

        //Create Payment
        Payment ccPayment = new Payment("CreditCard", "c-1234", 178.90);
        ccPayment.printDetails();
        System.out.println("---------------");
//        logger.debug("test12324---------------");

        //Create Customer
        Address custAddress = new Address("123 main st", "New York", "NY", "15632", "USA");
        System.out.println("Customer Address :" + custAddress.getAddress());
        Customer customer1 = new Customer("John Doe", 22, custAddress, 1, "123-456-7890", "customer1@test.com");
        System.out.println("Customer Details :" + customer1.getCustomerDetails());
        Customer customer2 = new Customer("Mike Doe", 18, custAddress, 2, "987-654-4321", "customer2@test.com");
        System.out.println("---------------");


        //hotel reservation
        Address hotelAddress = new Address("999 Boston st", "Chicago", "IL", "87343", "USA");
        System.out.println("Hotel Address :" + hotelAddress.getAddress());
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
        System.out.println("---------------");

        // car reservation
        CarReservation carReservation = new CarReservation("cr-676334", Status.BOOKED, Util.getDateFromStr("05/13/2023"), Util.getDateFromStr("05/17/2023"), 400.50, "suv", "7seaters");
        carReservation.addDriver(customer1);
        carReservation.addDriver(customer2);
        carReservation.removeDriver(customer2);
        carReservation.createReservation();
        carReservation.updateCarType("Sedan");
        carReservation.viewReservation();
        carReservation.cancelReservation();
        System.out.println("---------------");

        // flight reservation
        Flight flight = new Flight("F0145", "Logan International", "JFK", "F26");
        flight.checkIn();
        flight.allowIn();
        flight.printDetails();
        FlightReservation flightReservation = new FlightReservation("Fr-1388", Status.BOOKED, Util.getDateFromStr("05/12/2023"), Util.getDateFromStr("05/17/2023"), 800.00, 1234567, flight);
        flightReservation.addPassenger(customer1);
        flightReservation.addPassenger(customer2);
        flightReservation.removePassenger(customer1);
        flightReservation.createReservation();
        flightReservation.updateSeatNumber("A35");
        flightReservation.viewReservation();
        flightReservation.cancelReservation();
        System.out.println("---------------");


        // Create Booking
        Booking booking = new Booking("b-3456", Util.getCurrentDate(), customer1, ccPayment);

        // add reservations
        booking.addReservation(hotelReservation);
        booking.addReservation(carReservation);
        booking.addReservation(flightReservation);

        booking.createBooking();
        booking.updateCustomerPhoneNumber("345-435-5869");
        booking.viewBooking();
        booking.cancelBooking();
        System.out.println("---------------");


        //Create Employee
        Address empAddress = new Address("12 robert st", "Hartford", "CT", "34343", "USA");
        System.out.println("Employee Address :" + empAddress.getAddress());
        Employee agent = new Employee("Adam Smith", 34, empAddress, 101, 2, 50000);
        System.out.println("Employee Details :" + agent.getEmployeeDetails());

        //Create Manager
        Address mgrAddress = new Address("26 grove st", "Boston", "MA", "01233", "USA");
        System.out.println("Manager Address :" + mgrAddress.getAddress());
        Manager manager = new Manager("Sam Adams", 47, mgrAddress, 100, 1, 120000);
        manager.recruitEmployee(agent);
        manager.changeSalary(agent.getEmployeeId());
        System.out.println("Manager :" + manager.getEmployees());
        System.out.println("---------------");

        Util.printAvailableStatuses();


    }
}