package vulnerable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    public static void main(String[] args) {
        String username = "admin";
        String password = "' OR '1'='1";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Logged in!");
            } else {
                System.out.println("Invalid login.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
