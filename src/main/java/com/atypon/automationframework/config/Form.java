package com.atypon.automationframework.config;

import com.atypon.automationframework.actions.FormAction;
import com.atypon.automationframework.drivers.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rzzayed on 6/21/17.
 */
@XmlRootElement(name = "form")
@XmlAccessorType(XmlAccessType.FIELD)
public class Form extends Item
{
    public static Map<String, String> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(Map<String, String> hashMap) {
        Form.hashMap = hashMap;
    }

    public ArrayList<SetText> getSetTexts() {
        return setTexts;
    }

    public void setSetTexts(ArrayList<SetText> setTexts) {
        this.setTexts = setTexts;
    }

    static Map<String,String> hashMap = new HashMap<String, String>();

    @XmlAttribute(name ="name")
    private  String formName;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @XmlElement(name = "param")
    private ArrayList<Param>params;
    @XmlElement(name = "setText")
    private ArrayList<SetText>setTexts;

    public ArrayList<Param> getParams() {
        return params;
    }

    public void setParams(ArrayList<Param> params) {
        this.params = params;
    }


    public  void doAction(WebDriver driver) {
        for (Param param : this.getParams()) {
            if (param.getType().equals("getFromTestCase"))
                DriverUtils.findElementByAll(driver, param.getId()).sendKeys(Main.getHashMap().get(param.getValue()));
            else if (param.getType().equals("fillFromKeyboard"))
                DriverUtils.findElementByAll(driver, param.getId()).sendKeys(param.getValue());
            else if (param.getType().equals("radio"))
                DriverUtils.findElementByAll(driver, param.getId()).click();
            else if (param.getType().equals("dropdown")) {
                Select drpAccount = new Select( DriverUtils.findElementByAll(driver, param.getId()));
                drpAccount.selectByValue(param.getValue());
            }

        }
        new FormAction().action(driver,this);
    }


}
