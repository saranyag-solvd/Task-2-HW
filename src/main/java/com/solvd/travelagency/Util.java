package com.solvd.travelagency;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void uniqueWords() {

        try {
            String fileContent = FileUtils.readFileToString(new File("input.txt"), "UTF-8");
            LOGGER.debug("File Content :" + fileContent);

            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(fileContent);
            int wordsCnt = 0, uniqueCnt = 0;

            StringBuffer buf = new StringBuffer("Unique Words :");
            while (matcher.find()) {
                String word = matcher.group();
                if (StringUtils.countMatches(fileContent, word) == 1) {
                    uniqueCnt++;
                    buf.append(word).append(" ");
                }
                wordsCnt++;
            }

            buf.insert(0, "Unique Words Count :" + uniqueCnt + "\n\n");
            buf.insert(0, "Words Count :" + wordsCnt + "\n");
           LOGGER.debug("Output :" + buf);
            FileUtils.writeStringToFile(new File("output.txt"), buf.toString());

        } catch (Exception e) {
           LOGGER.error("Exception:" + e);
        }
    }

    public static void main(String[] args) {
        Util.uniqueWords();
    }
}
