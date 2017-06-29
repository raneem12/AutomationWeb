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


    public ArrayList<SetText> getSetTexts() {
        return setTexts;
    }

    public void setSetTexts(ArrayList<SetText> setTexts) {
        this.setTexts = setTexts;
    }


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
      new FormAction().fillForm(this.getParams(),driver);
      new FormAction().action(driver,this);
    }


}
