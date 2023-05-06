package Defines;

public class Admin {
    private String username;
    private String email;
    private String password;

    public Admin(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Admin) {
            Admin other = (Admin) obj;
            return this.username.equals(other.username) && this.password.equals(other.password);
        }
        return false;
    }
}