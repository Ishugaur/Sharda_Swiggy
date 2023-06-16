package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Sharda Swiggy Delivery App.");
        System.out.println();

        // Display menu options
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Restaurants Choose from which you wanna enter"+"\n");
        Restro.displayMenu("C:\\Users\\DELL\\IdeaProjects\\Sharda_Swiggy\\src\\main\\java\\org\\example\\Restro1.csv");
        System.out.println("\n"+"Choose resturant to continue");
        int restro = scanner.nextInt();
        System.out.println();

        Dish.menu(restro);
        Dish.displayMenu("C:\\Users\\DELL\\IdeaProjects\\Sharda_Swiggy\\src\\main\\java\\org\\example\\  Menu.csv");

        System.out.println("\n"+"Choose Dishes you want to eat by their Dish Id");
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] dishIdsArray = input.split(",");
        Map<Integer, Integer> dishQuantities = new HashMap<>();

        for (String dishId : dishIdsArray) {
            int id = Integer.parseInt(dishId.trim());
            System.out.printf("Enter quantity for dish ID %d: ", id);
            int quantity = scanner.nextInt();
            dishQuantities.put(id, quantity);
        }

        double bill = calculateBill(restro, dishQuantities);
        System.out.printf("\nYour total bill is: %.2f\n", bill);

        scanner.close();
    }

    public static double calculateBill(int restaurantId, Map<Integer, Integer> dishQuantities) {
        double totalBill = 0.0;
        String[][] menuData = Dish.displayMenu("C:\\Users\\DELL\\IdeaProjects\\Sharda_Swiggy\\src\\main\\java\\org\\example\\Menu.csv");

        if (menuData == null) {
            System.out.println("Failed to read menu data.");
            return totalBill;
        }

        System.out.println("\nCalculating bill...\n");

        for (String[] row : menuData) {
            int currRestaurantId = Integer.parseInt(row[0]);
            int dishId = Integer.parseInt(row[1]);
            String dishName = row[2];
            double dishPrice = Double.parseDouble(row[3]);

            if (currRestaurantId == restaurantId && dishQuantities.containsKey(dishId)) {
                int quantity = dishQuantities.get(dishId);
                double itemTotal = dishPrice * quantity;
                System.out.printf("Dish: %-10s Quantity: %d Price: %.2f\n", dishName, quantity, itemTotal);
                totalBill += itemTotal;
            }
        }

        return totalBill;
    }
}