package com.atypon.automationframework.report;

import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reporter {

    private static List<Result> details;
    private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";

    private Reporter() {
    }

    private static final class SingletonHolder {
        private static final Reporter INSTANCE = new Reporter();
    }

    public static Reporter get() {
        return SingletonHolder.INSTANCE;
    }

    public static void initialize() {
        details = new ArrayList<Result>();
    }

    public void report(WebDriver driver, String expectedValue) {
       report(driver, driver.getPageSource(), expectedValue);
    }

    public void report(WebDriver driver, String alertMessage, String expectedValue) {
        if (alertMessage.equals(expectedValue)) {
            Result r = new Result("Pass", expectedValue);
            details.add(r);
        } else {
            Result r = new Result("Fail", expectedValue);
            details.add(r);
        }
    }

    public void showResults() {
        for (int i = 0; i < details.size(); i++) {
            System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
        }
    }

    public void writeResults() {
        FileWriter output = null;
        try {
            String reportIn = new Scanner(new File("/home/rzzayed/Downloads/WebBasedAutomationFramework/report_template.html")).useDelimiter("\\Z").next();
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
                } catch (IOException ignore) {

                }
            }
        }
    }
}