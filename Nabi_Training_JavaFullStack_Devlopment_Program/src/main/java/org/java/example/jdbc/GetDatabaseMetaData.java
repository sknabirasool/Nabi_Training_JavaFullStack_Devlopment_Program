package org.java.example.jdbc;
import java.sql.Connection;
        import java.sql.DatabaseMetaData;
        import java.sql.DriverManager;
        import java.sql.ResultSet;

public class GetDatabaseMetaData {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cubic_way_db";
        String user = "root";
        String password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Display general database information
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Logged User: " + metaData.getUserName());
            System.out.println("JDBC Driver: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
            System.out.println("Database URL: " + metaData.getURL());
            // List all tables in the database
            System.out.println("\n----- Tables -----");
            try (ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" })) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println(tableName);
                    // List columns for each table
                    System.out.println("  ----- Columns for " + tableName + " -----");
                    try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
                        while (columns.next()) {
                            System.out.println("  " + columns.getString("COLUMN_NAME") + " (" + columns.getString("TYPE_NAME") + ")");
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
