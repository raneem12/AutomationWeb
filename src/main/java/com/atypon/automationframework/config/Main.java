package com.atypon.automationframework.config;

import com.atypon.automationframework.drivers.DriverManager;
import com.atypon.automationframework.drivers.DriversInfo;
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

    public static Map<String, String> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(Map<String, String> hashMap) {
        Main.hashMap = hashMap;
    }

    private static Map<String,String> hashMap = new HashMap<String, String>();

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        ChromeDriverManager.getInstance().setup();

        driver = DriverManager.get().newInstance(DriversInfo.CHROME);
        //String baserl = "http://demo.guru99.com/";



        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Unmarshaller um = context.createUnmarshaller();
        Scenario scenario = (Scenario) um.unmarshal(new FileReader("regNew.xml"));

        for (TestCase testCase : scenario.getTestCases()) {
            ArrayList<Item> items = testCase.getItems();
            for (Item item : items) {

                    item.doAction(driver);

              /*  else if (item instanceof com.atypon.automationframework.config.Form) {

                  com.atypon.automationframework.config.Form.doAction(driver, (com.atypon.automationframework.config.Form) item);

                } else if (item instanceof com.atypon.automationframework.config.GetText) {
                   // hashMap.put(((com.atypon.automationframework.config.GetText) item).getKey(),com.atypon.automationframework.drivers.DriverUtils.findElementByAll(driver, ((com.atypon.automationframework.config.GetText) item).getId()).getText());
                }
                else if (item instanceof com.atypon.automationframework.config.ClickLink) {
                    DriverUtils.findElementByAll(driver, ((com.atypon.automationframework.config.ClickLink) item).getName()).click();
                }
                else if (item instanceof com.atypon.automationframework.config.AlertAcceptAction){
                    com.atypon.automationframework.config.AlertAcceptAction.action(driver);
                }
                else if (item instanceof com.atypon.automationframework.config.ValidateText){
                    System.out.println("hello");
                    com.atypon.automationframework.config.ValidateText.validate(driver,((com.atypon.automationframework.config.ValidateText) item).getValue());
                }
                else System.out.println("no");*/
            }
        }
    }
}
