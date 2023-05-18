import java.util.HashMap;
import java.util.Scanner;

import Actions.AdminActions;
import Actions.UserActions;
import Defines.Cart;
import Menus.Menu;
import Menus.StoreMenu;

public class project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = Menu.displayMainMenu(scanner);

        HashMap<String, Object> authRes;

        authRes = new HashMap<String, Object>();
        authRes.put("isLoggedIn", false);
        authRes.put("userType", "");

        switch (choice) {
            case 1:
                authRes = Menu.displayLogin(scanner);
                break;
            case 2:
                Menu.displayRegistration(scanner);
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (!authRes.get("isLoggedIn").equals(true)) {
            if (choice == 1) {
                System.out.println("Something went wrong. Please try again.");
                scanner.close();
            }
            if (choice == 2) {
                System.out.println("Registration successful. press enter to continue.");
                scanner.nextLine();
                return;
            }
            if (choice == 3) {
                System.out.println("Goodbye!");
                scanner.close();
            }
        }
        boolean storeExit = false;

        Cart cart = new Cart();
        while (!storeExit) {

            choice = StoreMenu.displayMenu((String) authRes.get("userType"), scanner);

            if (authRes.get("userType").equals("admin")) {
                if (choice == 5) {
                    System.out.println("Goodbye!");
                    storeExit = true;
                    continue;
                }
                AdminActions adminActions = new AdminActions();
                adminActions.setAction(choice);
                adminActions.doAction(scanner);
            } else {
                UserActions userActions = new UserActions();
                userActions.setAction(choice);
                userActions.doAction(scanner, cart);
                if (choice == 4) {
                    System.out.println("Goodbye!");
                    storeExit = true;
                    continue;
                }
            }
        }
        scanner.close();

    }
}