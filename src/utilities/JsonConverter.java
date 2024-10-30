package utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.TestResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    static ObjectMapper mapper = new ObjectMapper();

    public static List<TestResult> jsonToObject(String filePath){
        File file = new File(filePath);
        try {
             return mapper.readValue(file, new TypeReference<List<TestResult>>() {
            });
        } catch (IOException e) {
            System.out.println("no se pudo leer el archivo" + e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
}
