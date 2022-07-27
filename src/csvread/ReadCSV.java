package csvread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadCSV {
    private final String FILE_PATH = "C:\\Users\\Darius\\Desktop\\Training\\T3\\src\\csvread\\mapdemo.csv";
    private final Map<String, Integer> consolidatedValues = new HashMap<>();

    public void voidAddElementToMapIfUnique(String userId, String orderValue){
        if(consolidatedValues.containsKey(userId)){
            consolidatedValues.put(userId, consolidatedValues.get(userId) + Integer.parseInt(orderValue));
        } else{
            consolidatedValues.put(userId, Integer.parseInt(orderValue));
        }
    }
    public Map<String, Integer> readAndReturnConsolidatedValues() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                String userId = values[0];
                String orderValue = values[1];
                if(!orderValue.equals("Cost of Order")) {
                    voidAddElementToMapIfUnique(userId, orderValue);
                }
            }
        }
        return consolidatedValues;
    }

    public static void main(String[] args) {

        ReadCSV application = new ReadCSV();
        try {
            application.readAndReturnConsolidatedValues();
        } catch (IOException e){
            System.out.println("File not found");
        }
        application.consolidatedValues.entrySet().forEach(entry -> {
            System.out.println("User ID: " + entry.getKey() + " | " + " value: " + entry.getValue());
        });
    }
}
