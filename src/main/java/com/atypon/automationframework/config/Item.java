package com.atypon.automationframework.config;

import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ValidateText.class, Form.class, GetText.class,ClickLink.class,Alert.class, Navigate.class})
public  abstract class Item {

    public abstract void execute(WebDriver driver);

}
