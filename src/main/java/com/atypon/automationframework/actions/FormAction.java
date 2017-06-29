package com.atypon.automationframework.actions;

import com.atypon.automationframework.config.Form;
import com.atypon.automationframework.config.Item;
import com.atypon.automationframework.config.Main;
import com.atypon.automationframework.config.Param;
import com.atypon.automationframework.drivers.DriverUtils;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

/**
 * Created by rzzayed on 6/29/17.
 */
public class FormAction extends Action {

    public void action(WebDriver driver, Item item) {
        fillForm(((Form) item).getParams(), driver);
        DriverUtils.findElementByAll(driver, ((Form) item).getFormName()).submit();
    }

    public void fillForm(ArrayList<Param> params, WebDriver driver) {
        for (Param param : params) {
            if (param.getType().equals("getFromTestCase"))
                DriverUtils.findElementByAll(driver, param.getId()).sendKeys(Main.getHashMap().get(param.getValue()));
            else if (param.getType().equals("fillFromKeyboard"))
                DriverUtils.findElementByAll(driver, param.getId()).sendKeys(param.getValue());
            else if (param.getType().equals("radio"))
                DriverUtils.findElementByAll(driver, param.getId()).click();
            else if (param.getType().equals("dropdown")) {
                Select drpAccount = new Select(DriverUtils.findElementByAll(driver, param.getId()));
                drpAccount.selectByValue(param.getValue());
            }
        }
    }
}
