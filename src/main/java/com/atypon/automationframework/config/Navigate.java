package com.atypon.automationframework.config;

import org.openqa.selenium.WebDriver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Raneem on 27/06/2017.
 */
@XmlRootElement(name = "navigate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Navigate extends Item {
    @XmlAttribute(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void execute(WebDriver driver) {
        driver.get(url);
    }

}
