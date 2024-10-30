package utilities;

import java.io.*;

public class FileManagement {


    public static void createFile(String filePath){
        File file = new File(filePath);
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print("");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el archivo: " + filePath);
        }
    }

    public static void write(String filePath, String data) {
        File file = new File(filePath);
        if(!file.exists()){
            createFile(filePath);
        }
        PrintWriter printer = null;
        try {
            printer = new PrintWriter(new FileWriter(filePath, true));
            printer.println(data);
            printer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + filePath);
        }
    }

    public static String read(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String currentLine = null;

            currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                fileContent.append(currentLine);
                currentLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + filePath);
        }
        return fileContent.toString();
    }

    public static void addDataToFile(String filePath, String data)  {
        File file = new File(filePath);
        if(!file.exists()){
            createFile(filePath);
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
            pw.println(data);
        } catch (IOException e) {
            System.out.println("Error al agregar datos al archivo: " + filePath);
        }
    }


}
