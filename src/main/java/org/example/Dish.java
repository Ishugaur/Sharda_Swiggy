package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Dish {

    public static void menu(int n) {
        String restaurantFile = "Restro.csv";
        String menuFile = "C:\\Users\\DELL\\IdeaProjects\\Sharda_Swiggy\\src\\main\\java\\org\\example\\Menu.csv";

        String[][] menuData = displayMenu(menuFile);

        if (menuData == null) {
            System.out.println("Failed to read menu data.");
            return;
        }

        String[][] restaurantData = displayMenu(restaurantFile);

        // Get user input for the chosen restaurant
        int chosenRestaurantId = n;

        // Find the dishes for the chosen restaurant
        System.out.println("\n"+"Menu for Restaurant ID " + chosenRestaurantId + ":");
        for (String[] row : menuData) {
            int restaurantId = Integer.parseInt(row[0]);
            int dishId = Integer.parseInt(row[1]);
            String dishName = row[2];
            double dishPrice = Double.parseDouble(row[3]);

            if (restaurantId == chosenRestaurantId) {
                System.out.print("Dish ID:" + " " + dishId);
                System.out.println("   Name: " + " " + dishName );
                System.out.print("Price: " + " " +dishPrice + "\n"+ "\n" );
            }

        }
    }


    public static String[][] displayMenu(String csvFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            int numRows = 0;

            int numCols = -1;

            // Determine the number of rows and columns in the CSV file
            while ((line = reader.readLine()) != null) {
                numRows++;
                String[] values = line.split(",");
                if (numCols == -1) {
                    numCols = values.length;
                } else if (numCols != values.length) {
                    System.out.println("Error: Inconsistent number of columns in CSV file.");
                    return null;
                }
            }

            String[][] data = new String[numRows][numCols];

            // Read the CSV file and store the data in a 2D array
            reader.close();

            BufferedReader read = new BufferedReader(new FileReader(csvFilePath));
            int rowIndex = 0;

            while ((line = read.readLine()) != null) {
                String[] values = line.split(",");
                data[rowIndex++] = values;
            }

            return data;
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
            return null;
        }
    }

}
