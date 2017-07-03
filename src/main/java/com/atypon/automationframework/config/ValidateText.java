package com.atypon.automationframework.config;

import com.atypon.automationframework.report.Reporter;
import static com.atypon.automationframework.util.StringUtil.equalsIgnoreCase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

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
    private String type = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void execute(WebDriver driver) {

        if (equalsIgnoreCase(type, "alert")) {

            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            Reporter.get().report(driver, alertMessage, value);
        } else {

            Reporter.get().report(driver, value);
        }

       /* if (driver.getPageSource().contains(value)) {
            System.out.println("yes");
        } else System.out.println("faill");*/
    }
}
