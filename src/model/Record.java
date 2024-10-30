package model;

import java.util.Objects;

public class Record {
    private String dni;
    private Double temperature;

    public Record() {
    }

    public Record(String dni, Double temperature) {
        this.dni = dni;
        this.temperature = temperature;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record record)) return false;
        return Objects.equals(dni, record.dni) && Objects.equals(temperature, record.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, temperature);
    }

    @Override
    public String toString() {
        return "Record{" +
                "dni='" + dni + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}