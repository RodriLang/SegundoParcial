import exception.AmountOfReagentsException;
import exception.HighTemperatureException;
import model.Person;
import model.Record;
import model.SSM;
import model.TestResult;
import service.SSM_service;
import service.TestResultService;
import utilities.FileManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SSM ssm = new SSM(1);
        Person p1 = new Person("Jose", "Lopez", 22, "El grosellar", "25654654", "Carpintero");
        Person p2 = new Person("Mariano", "Manzur", 52, "San martin", "25654564", "Carpintero");
        Person p3 = new Person("Lidia", "Juarez", 66, "San Jose", "25544654", "Carpintero");
        Person p4 = new Person("Hernan", "Maiz", 32, "Villa Lourdes", "25234654", "Carpintero");
        Person p5 = new Person("Julieta", "Lujan", 27, "Colinas de Peralta Ramos", "25650054", "Carpintero");

        SSM_service ssmService = new SSM_service();
        try {
            ssmService.addTestingPerson(p1, ssm);
        } catch (AmountOfReagentsException e) {
            System.out.println(e.getMessage());
            if (ssmService.hasMoreTest()) {
                ssm.setAmountOfTests(ssm.getAmountOfTests() + 1);
            }
        }

        try {
            ssmService.addTestingPerson(p2, ssm);
        } catch (AmountOfReagentsException e) {
            System.out.println(e.getMessage());
            if (ssmService.hasMoreTest()) {
                ssm.setAmountOfTests(ssm.getAmountOfTests() + 1);
            }
        }

        Map<Integer, Record> testings = ssmService.toTest(ssm);

        try {
            ssmService.isolate(testings, ssm);
        } catch (HighTemperatureException e) {
            System.out.println("Se guardo un regitro de la persona aislada");
        }


        TestResult testResult = new TestResult();
        testResult.setSane(new ArrayList<>(ssm.getTestingPeople()));
        testResult.setIsolate(List.of(List.of(ssm.getTestingPeople().toString())));
        TestResultService testResultService = new TestResultService();

        testResultService.generateJson(testResult);
    }


}

