package Defines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<String> books;

    public Cart() {
        this.books = new ArrayList<String>();
    }

    public void addBook(String bookName) {
        // read all books names into an array of strings
        ArrayList<String> availableBooks = new ArrayList<String>();
        File booksDirectory = new File("data/books/");
        File[] files = booksDirectory.listFiles();
        for (File file : files) {
            // print first line of the file
            try (Scanner scanner = new Scanner(file)) {
                availableBooks.add(scanner.nextLine());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // check if book already exists in availableBooks
        if (availableBooks.contains(bookName)) {
            this.books.add(bookName);
            System.out.println("Book added to cart." + "->" + bookName);
        } else {
            System.out.println("Book does not exist.");
        }
    }

    public void viewCart() {
        double total = 0.0;
        System.out.println("Books in cart: ");
        for (String book : books) {
            String fileName = book.replaceAll(" ", "_");
            // read the book file and add up the price
            File bookFile = new File("data/books/" + fileName + ".txt");
            try (Scanner scanner = new Scanner(bookFile)) {
                scanner.nextLine(); // skip the title
                scanner.nextLine(); // skip the author
                scanner.nextLine(); // skip the description
                double price = Double.parseDouble(scanner.nextLine().trim());
                total += price;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(book);
        }
        System.out.println("Total price: $" + total);
    }
}
