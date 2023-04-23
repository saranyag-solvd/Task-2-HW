# Task2 HomeWork - Travel Agency System

Class with Main Method - TravelAgency.java

### Main method output
```
Payment{ paymentMethod=CreditCard, confirmationNumber=c-1234, amount=178.9}
---------------
Customer Address :Address{street='123 main st', city='New York', state='NY', zipcode='15632', country='USA'}
Customer Details :Customer Details :Customer{customerId=1, phoneNumber='123-456-7890', emailAddress='customer1@test.com'}
---------------
Hotel Address :Address{street='999 Boston st', city='Chicago', state='IL', zipcode='87343', country='USA'}
Checked into Hotel
Allowed into Hotel Room
Checked out of Hotel
Printing Hotel Details :Hotel{name='Marriot', address=Address{street='999 Boston st', city='Chicago', state='IL', zipcode='87343', country='USA'}, roomNumber='43B'}
Hotel reservation created
Hotel no.of Guests updated
Hotel Reservation Details:
reservationId='hr-8765', status='CONFIRMED', fromDate=Sat May 13 00:00:00 EDT 2023, toDate=Wed May 17 00:00:00 EDT 2023, amount=589.65
HotelReservation{roomType='Suite', noOfGuest=5, hotel=Hotel{name='Marriot', address=Address{street='999 Boston st', city='Chicago', state='IL', zipcode='87343', country='USA'}, roomNumber='43B'}, amenities='Swimming pool, gym'}
Hotel reservation cancelled
---------------
Car Driver Added
Car Driver Added
Car Driver Removed
Car reservation created
Car type updated
Car Reservation Details:
reservationId='cr-676334', status='CONFIRMED', fromDate=Sat May 13 00:00:00 EDT 2023, toDate=Wed May 17 00:00:00 EDT 2023, amount=400.5
CarReservation{carType='Sedan', drivers=[Customer{customerId=1, phoneNumber='123-456-7890', emailAddress='customer1@test.com'}], carDetails='7seaters'}
car reservation cancelled
---------------
Checked into Flight
Allowed inside Aircraft
Printing Flight Details :Flight{flightNumber='F0145', arrivalAirport='Logan International', destinationAirport='JFK', seatNumber='F26'}
passenger added
passenger added
passenger removed
Flight reservation created
Flight seat number updated
Flight Reservation Details:
reservationId='Fr-1388', status='CONFIRMED', fromDate=Fri May 12 00:00:00 EDT 2023, toDate=Wed May 17 00:00:00 EDT 2023, amount=800.0
FlightReservation{pnrNumber=1234567, flight=Flight{flightNumber='F0145', arrivalAirport='Logan International', destinationAirport='JFK', seatNumber='A35'}, passengers=[Customer{customerId=2, phoneNumber='987-654-4321', emailAddress='customer2@test.com'}]}
Flight reservation cancelled
---------------
Hotel reservation created
Car reservation created
Flight reservation created
Booking created
Booking Details :Booking{bookingId='b-3456', date=Sun Apr 23 15:43:39 EDT 2023, customer=Customer{customerId=1, phoneNumber='345-435-5869', emailAddress='customer1@test.com'}, reservations=[HotelReservation{roomType='Suite', noOfGuest=5, hotel=Hotel{name='Marriot', address=Address{street='999 Boston st', city='Chicago', state='IL', zipcode='87343', country='USA'}, roomNumber='43B'}, amenities='Swimming pool, gym'}, CarReservation{carType='Sedan', drivers=[Customer{customerId=1, phoneNumber='345-435-5869', emailAddress='customer1@test.com'}], carDetails='7seaters'}, FlightReservation{pnrNumber=1234567, flight=Flight{flightNumber='F0145', arrivalAirport='Logan International', destinationAirport='JFK', seatNumber='A35'}, passengers=[Customer{customerId=2, phoneNumber='987-654-4321', emailAddress='customer2@test.com'}]}], payment=com.solvd.travelagency.Payment@2503dbd3}
Hotel reservation cancelled
car reservation cancelled
Flight reservation cancelled
Booking cancelled
---------------
Employee Address :Address{street='12 robert st', city='Hartford', state='CT', zipcode='34343', country='USA'}
Employee Details :Employee Details: Employee{employeeId=101, departmentNumber=2, salary=50000}
Employee added
Admin:[Employee{employeeId=101, departmentNumber=2, salary=55000}]
---------------
Inside static block in Status
Available Statuses :Status{booked='BOOKED', confirmed='CONFIRMED', cancelled='CANCELLED'}
```