package com.atypon.automationframework.actions;

import com.atypon.automationframework.config.Item;
import com.atypon.automationframework.config.Navigate;
import org.openqa.selenium.WebDriver;

/**
 * Created by rzzayed on 6/29/17.
 */
public class UrlAction extends Action{

    public  void action(WebDriver driver, Item item){
        driver.get(((Navigate)item).getUrl());
    }
}
