package Menus;

import java.util.Scanner;

public class StoreMenu {
    public static int displayMenu(String userType, Scanner scanner) {

        boolean validInput = false;
        int choice = 0;
        while (!validInput) {
            // clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (userType.equals("user")) {

                System.out.println("Welcome to the Online Bookstore!");
                System.out.println("1. View products");
                System.out.println("2. Add product to cart");
                System.out.println("3. Checkout");
                System.out.println("4. Exit store");
            }

            if (userType.equals("admin")) {
                System.out.println("1. View products");
                System.out.println("2. Add product");
                System.out.println("3. Remove product");
                System.out.println("4. Edit product");
                System.out.println("5. Exit store");
            } else {
            }

            System.out.println("Please choose an option: ");

            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid option. Please try again.");
                    continue;
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
        }
        return choice;

    }
}