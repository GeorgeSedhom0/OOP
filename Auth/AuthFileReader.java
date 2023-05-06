package Auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Defines.Admin;
import Defines.User;

public class AuthFileReader {
    private static final String USERS_FILE = "data/users.txt";
    private static final String ADMINS_FILE = "data/admins.txt";

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(USERS_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String username = fields[0];
                String email = fields[1];
                String password = fields[2];
                User user = new User(username, email, password);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Admin> getAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(ADMINS_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // format: username,email,password
                String[] fields = line.split(",");
                String username = fields[0];
                String email = fields[1];
                String password = fields[2];
                Admin admin = new Admin(username, email, password);
                admins.add(admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return admins;
    }
}