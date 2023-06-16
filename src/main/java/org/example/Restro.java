package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Restro {
    public static void displayMenu(String csvFilePath) {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String item : row) {
                    System.out.printf("%-10s", item);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading the menu file: " + e.getMessage());
        }
    }
}