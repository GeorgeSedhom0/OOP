package Writers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Defines.Book;

public class BookFileWriter {
    private static final String BOOKS_DIRECTORY = "data/books/";

    public static void writeBook(Book book) {
        String fileName = BOOKS_DIRECTORY + book.getTitle().replaceAll(" ", "_") + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(book.getTitle() + "\n");
            writer.write(book.getAuthor() + "\n");
            writer.write(book.getCategory() + "\n");
            writer.write(Double.toString(book.getPrice()));
            System.out.println("Book written successfully.");
            System.out.println("Book: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Price: " + book.getPrice());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(String bookName) {
        String fileName = BOOKS_DIRECTORY + bookName.replaceAll(" ", "_") + ".txt";
        File file = new File(fileName);
        // if file exists, delete it
        if (file.exists()) {
            file.delete();
            System.out.println("Book deleted successfully.");

        } else {
            System.out.println("File does not exist");
        }
    }

    public static void editBook(String bookName, Book book) {
        // if file Does not exist, stop editing
        String fileName = BOOKS_DIRECTORY + bookName.replaceAll(" ", "_") + ".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        // if file exists, delete it and create a new one
        file.delete();
        writeBook(book);
        System.out.println("Book edited successfully.");

    }
}
