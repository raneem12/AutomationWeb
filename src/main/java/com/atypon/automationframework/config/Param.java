package com.atypon.automationframework.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "param")
@XmlAccessorType(XmlAccessType.FIELD)
public class Param {
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "value")
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute(name = "type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
