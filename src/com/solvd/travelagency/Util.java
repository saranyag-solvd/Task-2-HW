package com.solvd.travelagency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    private static final Logger LOGGER = LogManager.getLogger(Util.class);

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

    public static void printFile(String folderPath, String fileName, String fileExtension) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(folderPath + fileName + fileExtension);
            BufferedReader br = new BufferedReader(fileReader);
            printFile(br);
        } catch (IOException e) {
            LOGGER.error("Exception caught : " + e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    LOGGER.error("Exception in finally : " + e);
                }
            }
        }
    }

    public static void printFile(String folderPath, String fileName) throws IOException {
        FileReader fileReader = new FileReader(folderPath + fileName);
        BufferedReader br = new BufferedReader(fileReader);
        printFile(br);
    }

    public static void printFile(String filepath) {
        try (FileReader fileReader = new FileReader(filepath)) {
            BufferedReader br = new BufferedReader(fileReader);
            printFile(br);
        } catch (IOException e) {
            LOGGER.error("Exception caught in try with resources : " + e);
        }
    }

    private static void printFile(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            // Print the string
            System.out.println(line);
        }
    }

}
