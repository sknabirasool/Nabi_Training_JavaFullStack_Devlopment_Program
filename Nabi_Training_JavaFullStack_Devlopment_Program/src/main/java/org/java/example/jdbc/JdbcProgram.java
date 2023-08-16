package org.java.example.jdbc;
import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
public class JdbcProgram {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/cubic_way_db";
        String user = "root";
        String password ="";
        try {
            // 1. Load the driver (for modern drivers, this step is optional)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            // 3. Create a statement
            Statement statement = connection.createStatement();
            // 4. Execute SQL queries
            // Create a table
            statement.execute("CREATE TABLE IF NOT EXISTS students(id INT PRIMARY KEY, name VARCHAR(50))");
            // Insert a record
            statement.executeUpdate("INSERT INTO students(id, name) VALUES (1, 'John Doe')");
            // Fetch the record
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE id = 1");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }
            // Delete the record
            statement.executeUpdate("DELETE FROM students WHERE id = 1");
            // 5. Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
