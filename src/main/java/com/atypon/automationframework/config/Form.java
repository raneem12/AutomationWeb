package com.atypon.automationframework.config;

import com.atypon.automationframework.Main;
import com.atypon.automationframework.drivers.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by rzzayed on 6/21/17.
 */
@XmlRootElement(name = "form")
@XmlAccessorType(XmlAccessType.FIELD)
public class Form extends Item {


    public ArrayList<SetText> getSetTexts() {
        return setTexts;
    }

    public void setSetTexts(ArrayList<SetText> setTexts) {
        this.setTexts = setTexts;
    }


    @XmlAttribute(name = "name")
    private String formName;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @XmlElement(name = "param")
    private ArrayList<Param> params;
    @XmlElement(name = "setText")
    private ArrayList<SetText> setTexts;

    public ArrayList<Param> getParams() {
        return params;
    }

    public void setParams(ArrayList<Param> params) {
        this.params = params;
    }


    public void doAction(WebDriver driver) {
        for (Param param : params) {
            WebElement element = DriverUtils.findElementByAll(driver, param.getId());
            if (param.getType().equals("getFromTestCase"))
                element.sendKeys(Main.getHashMap().get(param.getValue()));
            else if (param.getType().equals("fillFromKeyboard"))
                element.sendKeys(param.getValue());
            else if (param.getType().equals("radio"))
                element.click();
            else if (param.getType().equals("dropdown")) {
                Select drpAccount = new Select(element);
                drpAccount.selectByValue(param.getValue());
            }
        }
        DriverUtils.findElementByAll(driver, getFormName()).submit();

    }
}
