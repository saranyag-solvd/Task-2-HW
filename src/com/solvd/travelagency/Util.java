package com.solvd.travelagency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static void printAvailableStatuses() {
        Status status = new Status();
        status.printAvailableStatus();
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date getDateFromStr(String dateStr) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return date;
    }

}
