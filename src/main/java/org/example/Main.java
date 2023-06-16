package org.example;

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
        Dish.displayMenu("C:\\Users\\DELL\\IdeaProjects\\Sharda_Swiggy\\src\\main\\java\\org\\example\\Menu.csv");

        System.out.println("\n"+"Choose Dishes you want to eat by their Dish Id");



        scanner.close();
    }
}