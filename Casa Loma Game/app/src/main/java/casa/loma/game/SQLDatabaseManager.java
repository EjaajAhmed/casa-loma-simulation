package casa.loma.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/CasaLomaGame";
    private static final String USER = "ejaaj03"; // Your MySQL username
    private static final String PASSWORD = "root1234"; // Your MySQL password
 
    // Method to connect my code to the JDBC
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }
}
