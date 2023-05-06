package Menus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Auth.AuthLogin;
import Defines.Admin;
import Defines.User;
import Writers.UserFileWriter;

public class Menu {
    public static int displayMainMenu(Scanner scanner) {
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // starting main menu
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Welcome to the Online Bookstore!");
            System.out.println("Please select an option:");
            System.out.println("1) Log in");
            System.out.println("2) Register as a new user");
            System.out.println("3) Exit");

            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                // clear the console
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Invalid input. Please enter a number.");
            }

            if (choice < 1 || choice > 3) {
                // clear the console
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Invalid option. Please try again.");
                validInput = false;
            }
        }

        return choice;
    }

    public static HashMap<String, Object> displayLogin(Scanner scanner) {
        boolean isLoggedIn = false;
        String userType = "";
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (!isLoggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            // clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("User type:");
            System.out.println("1) User");
            System.out.println("2) Admin");

            String userTypeChoiceString = scanner.nextLine();
            int userTypeChoice = 0;
            try {
                userTypeChoice = Integer.parseInt(userTypeChoiceString);
            } catch (NumberFormatException e) {
                // clear the console
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (userTypeChoice == 1) {
                User user = new User(username, "", password);
                AuthLogin auth = new AuthLogin(user);
                isLoggedIn = auth.authenticate();
                userType = "user";
            } else if (userTypeChoice == 2) {
                Admin admin = new Admin(username, "", password);
                AuthLogin auth = new AuthLogin(admin);
                isLoggedIn = auth.authenticate();
                userType = "admin";
            } else {
                System.out.println("Invalid choice.");
            }

            if (!isLoggedIn) {
                // clear the console
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Login failed. Please try again.");
            }
        }
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("isLoggedIn", isLoggedIn);
        result.put("userType", userType);
        return result;
    }

    public static void displayRegistration(Scanner scanner) {
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // starting registration menu
        System.out.println("Please select a user type:");
        System.out.println("1) User");
        System.out.println("2) Admin");

        String userType = scanner.nextLine();

        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // get user information
        System.out.println("Please enter a username:");
        String name = scanner.nextLine();

        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Please enter an email address:");
        String email = scanner.nextLine();

        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Please enter a password:");
        System.out.println("(Note: your password will be hidden from view but it will still be recorded)");
        char[] password = scanner.nextLine().toCharArray();

        // save user information to file
        if (userType.equals("1")) {
            UserFileWriter.addUser(name, email, new String(password));
        } else if (userType.equals("2")) {

            // get admin password
            System.out.println("Please enter the admin password:");
            char[] adminPassword = scanner.nextLine().toCharArray();
            String adminPasswordStr = new String(adminPassword);

            // read expected admin password from file
            String expectedAdminPassword = "";
            try (Scanner scanner2 = new Scanner(new File("data/adminP.txt"));) {
                expectedAdminPassword = scanner.nextLine().trim();
            } catch (FileNotFoundException e) {
                System.out.println("Error: could not read admin password from file.");
                e.printStackTrace();
                return;
            }

            // check admin password
            if (!adminPasswordStr.equals(expectedAdminPassword)) {
                System.out.println("Invalid admin password. Please try again.");
                return;
            }

            UserFileWriter.addAdmin(name, email, new String(password));
        } else {
            System.out.println("Invalid user type. Please try again.");
            return;
        }

        System.out.println("User registered successfully!");

    }
}