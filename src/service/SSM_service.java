package service;

import exception.AmountOfReagentsException;
import exception.HighTemperatureException;
import model.Person;
import model.Record;
import model.SSM;
import utilities.FileManagement;

import java.util.*;

public class SSM_service {


    public Map<Integer, Record> toTest(SSM ssm) {
        Map<Integer, Record> recordMap = new LinkedHashMap<>();
        for (Person person : ssm.getTestingPeople()) {
            //creo un nuevo registro asignando el dni de la persona y la temperatura generada
            Record record = new Record(person.getDni(), getRandomTemperature());
            //agrego al map el numero de test asignado y el registro creado
            recordMap.put(generateTestNumber(), record);
        }
        return recordMap;
    }


    public void isolate(Map<Integer, Record> records, SSM ssm) throws HighTemperatureException {
        for(Map.Entry entry : records.entrySet()){
            Record record = (Record) entry.getValue();
            if(record.getTemperature()>=38){
                //obtengo el barrio de la persona buscandola por dni para enviar el parametro a la excepcion
                String neighborhood = getPersonByDni(record.getDni(), ssm).getNeighborhood();
                FileManagement.addDataToFile("urgente.dat", "Dni: "
                        + record.getDni()+" - Temperatura: "+record.getTemperature()+" - Numero de Kit: "+entry.getKey()+" - Barrio: "+neighborhood);
                throw new HighTemperatureException((Integer) entry.getKey(), neighborhood);
            }
        }
    }

    public void addTestingPerson(Person testingPerson, SSM ssm) throws AmountOfReagentsException {
        if (ssm.getTestingPeople() == null) {
            //si el valor es null me aseguro de instanciarlo antes de añadir
            ssm.setTestingPeople( new LinkedHashSet<>());
        }
        if (!ssm.getTestingPeople().add(testingPerson)) {
            //aprovecho el booleano del Set para saber si pudo almacenarlo o ya encontro el dni repetido
            System.out.println("La persona ya se encuentra registrada");
        } else {
            if (ssm.getTestingPeople().size()<ssm.getAmountOfTests()){
                ssm.getTestingPeople().add(testingPerson);
            } else {
                throw new AmountOfReagentsException("La cantidad de activos ha sido superada");
            }
        }
    }


    private Integer generateTestNumber() {
       return ++SSM.numberTest;
    }

    private Double getRandomTemperature() {
        //obtengo el numero entre 36 y 39 pero con muchos decimales
        Double randomTemperature = 36 + (Math.random() * (39 - 36));
        //redondeo a dos decimales
        randomTemperature = Math.round(randomTemperature * 100.0) / 100.0;
        return randomTemperature;
    }

    private Person getPersonByDni(String dni, SSM ssm){
        Person foundPerson = null;
        for(Person person : ssm.getTestingPeople()){
            if(person.getDni().equals(dni)){
                foundPerson=person;
            }
        }
        return foundPerson;
    }

    public Boolean hasMoreTest(){
        System.out.println("Hay 1 activo mas disponible");
           return true;
    }
}
