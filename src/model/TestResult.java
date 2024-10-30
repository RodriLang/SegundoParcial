package model;

import java.util.ArrayList;
import java.util.List;

public class TestResult {

    private List<Person> sane;
    private List<List<String>> isolate;

    public TestResult() {
    }

    public TestResult(List<Person> sane, List<List<String>> isolate) {
        this.sane = sane;
        this.isolate = isolate;
    }

    public List<Person> getSane() {
        return sane;
    }

    public void setSane(List<Person> sane) {
        this.sane = sane;
    }

    public List<List<String>> getIsolate() {
        return isolate;
    }

    public void addSanePerson(Person person){
        sane.add(person);

    }

    public void addIsolatePerson(String kit, String temperature, String neighborhood){
        List<String> isolate = new ArrayList<>();
        isolate.add("Kit: "+kit);
        isolate.add("temperature: "+temperature);
        isolate.add("neighborhood: "+neighborhood);
        isolate.add(String.valueOf(isolate));

    }


    public void setIsolate(List<List<String>> isolate) {
        this.isolate = isolate;
    }
}
