package com.solvd.travelagency.interfaces;

import com.solvd.travelagency.exceptions.BookingException;

public interface IBookingOperation {
    void createBooking();

    void viewBooking();

    void cancelBooking() throws BookingException;
}
