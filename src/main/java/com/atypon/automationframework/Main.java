package com.atypon.automationframework;

import com.atypon.automationframework.config.Item;
import com.atypon.automationframework.config.Scenario;
import com.atypon.automationframework.config.TestCase;
import com.atypon.automationframework.drivers.DriverManager;
import com.atypon.automationframework.drivers.DriversInfo;
import com.atypon.automationframework.report.Reporter;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rzzayed on 6/21/17.
 */
public class Main {
    private static WebDriver driver;
    private static Map<String, String> hashMap = new HashMap<String, String>();

    public static Map<String, String> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(Map<String, String> hashMap) {
        Main.hashMap = hashMap;
    }


    public static void main(String[] args) {
        ChromeDriverManager.getInstance().setup();

        driver = DriverManager.get().newInstance(DriversInfo.CHROME);
        //String baserl = "http://demo.guru99.com/";


        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Scenario.class);
            Unmarshaller um = context.createUnmarshaller();
            Scenario scenario = (Scenario) um.unmarshal(new FileReader("regNew.xml"));
            Reporter.initialize();

            for (TestCase testCase : scenario.getTestCases()) {
                ArrayList<Item> items = testCase.getItems();
                for (Item item : items) {
                    item.doAction(driver);
                }
            }
            Reporter.writeResults();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
