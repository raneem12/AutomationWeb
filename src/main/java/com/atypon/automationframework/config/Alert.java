package com.atypon.automationframework.config;

import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "AcceptAlertAction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alert extends Item {
    public void execute(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

}
