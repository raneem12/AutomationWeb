package com.atypon.automationframework.drivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    static  {
        /*System.setProperty("", )*/
    }

//    private static class Holder {
        private static final DriverManager INSTANCE = new DriverManager();
//    }

    public static DriverManager get() {
        return INSTANCE;
    }

    public WebDriver newInstance(DriversInfo info) {
        switch (info) {
            case CHROME:

                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
        }

        return null;
    }
}
