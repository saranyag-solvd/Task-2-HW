package com.solvd.travelagency;

import com.solvd.travelagency.exceptions.BookingException;

public interface IBookingOperation {
    void createBooking();

    void viewBooking();

    void cancelBooking() throws BookingException;
}
