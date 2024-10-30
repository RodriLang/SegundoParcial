package model;

import exception.AmountOfReagentsException;
import exception.HighTemperatureException;
import utilities.FileManagement;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SSM {
    public static Integer numberTest = 0;
    private Set<Person> testingPeople;
    private Integer amountOfTests;

    public SSM(Integer amountOfTests) {
        this.amountOfTests = amountOfTests;
    }

    public Set<Person> getTestingPeople() {
        return testingPeople;
    }

    public void setTestingPeople(Set<Person> testingPeople) {
        this.testingPeople = testingPeople;
    }

    public Integer getAmountOfTests() {
        return amountOfTests;
    }

    public void setAmountOfTests(Integer amountOfTests) {
        this.amountOfTests = amountOfTests;
    }

}
