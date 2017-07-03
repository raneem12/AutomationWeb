package com.atypon.automationframework.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "senario")
public class Scenario {
    @XmlElement(name = "test-case")
    private ArrayList<TestCase> testCases;


    public ArrayList<TestCase> getTestCases() {
        if (testCases == null){
            testCases = new ArrayList<>();
        }
        return testCases;
    }

}
