package Actions;

import java.util.Scanner;
import Defines.Book;
import Writers.BookFileWriter;

public class AdminActions extends StoreActions implements IAction {
    private int action;

    public void setAction(int action) {
        this.action = action;
    }

    public void doAction(Scanner scanner) {
        switch (this.action) {
            case 1:
                System.out.println("Viewing Books");
                displayBooks();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Adding Book");
                System.out.println("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.println("Enter Book Author: ");
                String author = scanner.nextLine();
                System.out.println("Enter Book Category: ");
                String category = scanner.nextLine();
                System.out.println("Enter Book Price: ");
                String priceString = scanner.nextLine();
                double price = Double.parseDouble(priceString);
                Book book = new Book(title, author, category, price);
                BookFileWriter.writeBook(book);
                break;
            case 3:
                System.out.println("Removing Book");
                System.out.println("Enter Book Title: ");
                String bookName = scanner.nextLine();
                BookFileWriter.deleteBook(bookName);
                break;
            case 4:
                System.out.println("Editing Book");
                System.out.println("Enter Book Title: ");
                bookName = scanner.nextLine();
                System.out.println("Enter Book New Title: ");
                title = scanner.nextLine();
                System.out.println("Enter Book Author: ");
                author = scanner.nextLine();
                System.out.println("Enter Book Category: ");
                category = scanner.nextLine();
                System.out.println("Enter Book Price: ");
                priceString = scanner.nextLine();
                price = Double.parseDouble(priceString);
                book = new Book(title, author, category, price);
                BookFileWriter.editBook(bookName, book);
                break;

        }
    }
}
