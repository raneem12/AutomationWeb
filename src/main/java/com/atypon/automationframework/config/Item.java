package com.atypon.automationframework.config;

import com.atypon.automationframework.actions.AlertAcceptAction;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by rzzayed on 6/22/17.
 */
@XmlSeeAlso({ValidateText.class, Form.class, GetText.class,ClickLink.class,AlertAcceptAction.class, Navigate.class})
public  abstract class Item {

    public abstract void doAction(WebDriver driver);

}
