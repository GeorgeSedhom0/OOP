package Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoreActions {
    protected static void displayBooks() {
        // read all files from /data/books
        // print the file names
        // close the files
        File booksDirectory = new File("data/books/");
        File[] files = booksDirectory.listFiles();
        for (File file : files) {
            // print first line of the file
            try (Scanner scanner = new Scanner(file)) {
                System.out.print(scanner.nextLine());
                scanner.nextLine(); // skip the author
                scanner.nextLine(); // skip the description
                System.out.print(" Price: " + scanner.nextLine()); // print the price
                System.out.println();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
