package com.atypon.automationframework.actions;

import com.atypon.automationframework.config.Form;
import com.atypon.automationframework.config.Item;
import com.atypon.automationframework.drivers.DriverUtils;
import org.openqa.selenium.WebDriver;

/**
 * Created by rzzayed on 6/29/17.
 */
public class FormAction extends Action {

    public void action(WebDriver driver, Item item) {
        DriverUtils.findElementByAll(driver, ((Form)item).getFormName()).submit();
    }
}
