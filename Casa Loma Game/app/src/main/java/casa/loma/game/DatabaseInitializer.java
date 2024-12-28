package casa.loma.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase(String filePath) {
        try (Connection conn = SQLDatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }

            stmt.execute(sql.toString());
            System.out.println("Database initialized successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to initialize the database.");
        }
    }
}
