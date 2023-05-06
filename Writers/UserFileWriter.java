package Writers;

import java.io.FileWriter;
import java.io.IOException;

public class UserFileWriter {
    public static void addUser(String name, String email, String password) {
        String userInfo = name + "," + email + "," + password + "\n";
        try {
            FileWriter writer = new FileWriter("data/users.txt", true);
            writer.write(userInfo);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void addAdmin(String name, String email, String password) {
        String adminInfo = name + "," + email + "," + password + "\n";
        try {
            FileWriter writer = new FileWriter("data/admins.txt", true);
            writer.write(adminInfo);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
