package Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class StoreActions {
    protected static void displayBooks() {
        File booksDirectory = new File("data/books/");
        File[] files = booksDirectory.listFiles();

        System.out.printf("%-20s | %-20s | %-10s | %-10s%n", "Title", "Author", "Category", "Price");
        System.out.println("-------------------------------------------------------------");

        for (File file : files) {
            try (Scanner scanner = new Scanner(file)) {
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                String category = scanner.nextLine();
                String price = scanner.nextLine();

                System.out.printf("%-20s | %-20s | %-10s | %-10s%n", title, author, category, price);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}