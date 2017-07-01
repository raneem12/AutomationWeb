package com.atypon.automationframework.config;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by rzzayed on 6/21/17.
 */
@XmlRootElement(name = "test-case")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestCase {
    @XmlElementRef
    private ArrayList<Item> items = new ArrayList<Item>();


    @XmlAttribute(name = "name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
