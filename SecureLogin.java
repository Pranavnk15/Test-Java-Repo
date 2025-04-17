package safe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecureLogin {
    public static void main(String[] args) {
        String username = "admin";
        String password = "password123";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Logged in securely!");
            } else {
                System.out.println("Invalid login.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
