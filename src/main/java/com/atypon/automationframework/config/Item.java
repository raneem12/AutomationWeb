package com.atypon.automationframework.config;

import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

@XmlSeeAlso({ValidateText.class, Form.class, GetText.class,ClickLink.class,Alert.class, Navigate.class})
public  abstract class Item {

    public abstract void execute(WebDriver driver);
//    public void setFormName(String x) {
//        System.out.println("hi");
//    }
//    public ArrayList<Param> getParams(){{
//        ArrayList <Param> arrayList = new ArrayList<>();
//        return arrayList;
//    }
//    }


}
