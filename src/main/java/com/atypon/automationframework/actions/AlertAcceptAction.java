package com.atypon.automationframework.actions;

import com.atypon.automationframework.config.Item;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Raneem on 26/06/2017.
 */
@XmlRootElement(name = "AcceptAlertAction")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlertAcceptAction extends Item
{
    public void doAction(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

}
