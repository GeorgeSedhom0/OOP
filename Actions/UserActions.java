package Actions;

import java.util.Scanner;
import Defines.Cart;

public class UserActions extends StoreActions implements IAction {
    private int action;

    public void setAction(int action) {
        this.action = action;
    }

    public void doAction(Scanner scanner, Cart cart) {
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch (this.action) {
            case 1:
                System.out.println("Viewing Books");
                displayBooks();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Add Books to Cart");
                displayBooks();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                System.out.println("Press Enter a book name to add to cart: ");
                String bookName = scanner.nextLine();
                cart.addBook(bookName);
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                break;
            case 3:
                System.out.println("Checkout");
                cart.viewCart();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                break;

        }
    }
}
