package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.TestResult;
import utilities.JsonConverter;

import java.io.File;
import java.io.IOException;

public class TestResultService {

    public void generateJson(TestResult testResult){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("test_result.json"), testResult);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo json");
        }
    }
}
