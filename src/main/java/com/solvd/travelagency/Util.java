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

    // Read a file, count unique words & write into a file
    public static void uniqueWords(String inputFile, String outputFile) {
        try {
            String fileContent = readFile(inputFile);
            LOGGER.debug("File Content :" + fileContent);
            StringBuffer buf = getUniqueWords(fileContent);
            LOGGER.debug("Output :" + buf);
            writeFile(outputFile, buf.toString());
        } catch (Exception e) {
            LOGGER.error("Exception:" + e);
        }
    }

    // Read file using FileUtil
    private static String readFile(String filePath) throws IOException {
        String fileContent = FileUtils.readFileToString(new File(filePath), "UTF-8");
        return fileContent;
    }

    // Write file using FileUtil
    private static void writeFile(String filePath, String content) throws IOException {
        FileUtils.writeStringToFile(new File(filePath), content);
    }

    // Get unique words & count in a string
    private static StringBuffer getUniqueWords(String fileContent) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(fileContent);
        int wordsCnt = 0, uniqueCnt = 0;
        StringBuffer buf = new StringBuffer("Unique Words :");
        while (matcher.find()) {
            String word = matcher.group();
            if (StringUtils.countMatches(fileContent.toLowerCase(), word.toLowerCase()) == 1) {
                uniqueCnt++;
                buf.append(word).append(" ");
            }
            wordsCnt++;
        }

        buf.insert(0, "Unique Words Count :" + uniqueCnt + "\n\n");
        buf.insert(0, "Words Count :" + wordsCnt + "\n");
        return buf;
    }

}
