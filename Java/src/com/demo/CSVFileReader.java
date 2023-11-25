package com.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader {
    public static void main(String[] args) {
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("demo.csv"))) {
            while ((line = br.readLine()) != null) {
                
                String[] values = line.split(csvSplitBy);

                try {
                    
                    int intValue = Integer.parseInt(values[0]);
                    String stringValue = values[1];
                    
                    System.out.println("IntValue: " + intValue + ", StringValue: " + stringValue);
                } catch (NumberFormatException e) {
                   
                    System.err.println("Error parsing values: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
