package model;

import java.util.Objects;

public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private String neighborhood;
    private String dni;
    private String occupation;

    public Person() {
    }

    public Person(String name, String lastName, Integer age, String neighborhood, String dni, String occupation) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
        this.occupation = occupation;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", neighborhood='" + neighborhood + '\'' +
                ", dni='" + dni + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
