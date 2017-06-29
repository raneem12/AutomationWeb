package com.atypon.automationframework.actions;

import com.atypon.automationframework.config.Item;
import org.openqa.selenium.WebDriver;

/**
 * Created by rzzayed on 6/29/17.
 */
public abstract class Action {
    public abstract void action(WebDriver driver, Item item);
}
