package com.atypon.automationframework.config;

import com.atypon.automationframework.testReport.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.Alert;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Raneem on 27/06/2017.
 */
@XmlRootElement(name = "validate-text")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidateText extends Item {

    @XmlAttribute(name = "value")
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute(name = "type")
    private String type = new String();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void doAction(WebDriver driver) {
        if (type.equals("alert")){
            Alert alert =driver.switchTo().alert();
            String alertMessage = alert.getText();
            Reporter.report(driver,alertMessage,value);
        }
        else
            Reporter.report(driver, value);

       /* if (driver.getPageSource().contains(value)) {
            System.out.println("yes");
        } else System.out.println("faill");*/
    }
}
