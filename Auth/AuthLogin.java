package Auth;

import java.util.ArrayList;

import Defines.Admin;
import Defines.User;

public class AuthLogin {
    private User user;
    private Admin admin;

    public AuthLogin(User user) {
        this.user = user;
    }

    public AuthLogin(Admin admin) {
        this.admin = admin;
    }

    public boolean authenticate() {
        ArrayList<User> users = AuthFileReader.getUsers();
        ArrayList<Admin> admins = AuthFileReader.getAdmins();

        boolean isAuthenticated = false;
        if (user != null) {
            // Check if the user is in the users list
            if (users.contains(user)) {
                User foundUser = users.get(users.indexOf(user));
                if (foundUser.getPassword().equals(user.getPassword())) {
                    System.out.println("User authentication successful.");
                    isAuthenticated = true;
                } else {
                    System.out.println("User authentication failed. Incorrect password.");
                    isAuthenticated = false;
                }
            } else {
                System.out.println("User authentication failed. User does not exist.");
                isAuthenticated = false;
            }
        } else if (admin != null) {
            // Check if the admin is in the admins list
            if (admins.contains(admin)) {
                Admin foundAdmin = admins.get(admins.indexOf(admin));
                if (foundAdmin.getPassword().equals(admin.getPassword())) {
                    System.out.println("Admin authentication successful.");
                    isAuthenticated = true;
                } else {
                    System.out.println("Admin authentication failed. Incorrect password.");
                    isAuthenticated = false;
                }
            } else {
                System.out.println("Admin authentication failed. Admin does not exist.");
                isAuthenticated = false;
            }
        } else {
            System.out.println("No user or admin provided.");
            isAuthenticated = false;
        }

        return isAuthenticated;
    }
}