package com.atypon.automationframework.testReport;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reporter {

    private static List<Result> details;
    private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
    private static final String templatePath = "Z:\\Documents\\Bas\\blog\\files\\report_template.html";

    public Reporter() {
    }

    public static void initialize() {
        details = new ArrayList<Result>();
    }

    public static void report(String actualValue, String expectedValue) {
        if (actualValue.equals(expectedValue)) {
            Result r = new Result("Pass", "Actual value '" + actualValue + "' matches expected value");
            details.add(r);
        } else {
            Result r = new Result("Fail", "Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'");
            details.add(r);
        }
    }

    public static void showResults() {
        for (int i = 0; i < details.size(); i++) {
            System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
        }
    }

    public static void writeResults() {
        FileWriter output = null;
        try {
            String reportIn = new Scanner(new File("/home/rzzayed/Downloads/testtest/src/main/java/com/atypon/automationframework/testReport/report_template.html")).useDelimiter("\\Z").next();
            //String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
            for (int i = 0; i < details.size(); i++) {
                reportIn = reportIn.replaceFirst(resultPlaceholder, "<tr><td>" + Integer.toString(i + 1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
            }

            String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String reportPath = "report_" + currentDate + ".html";


            output = new FileWriter(reportPath);
            BufferedWriter writer = new BufferedWriter(output);
            writer.append(reportIn);
            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error when writing report file:\n" + e.toString());
        } finally {
            if (output != null) {
                try {
                    output.flush();
                    output.close();
                } catch (IOException e) {

                }
            }
        }
    }
}