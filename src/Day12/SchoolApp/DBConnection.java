package Day12.SchoolApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String DB_DRIVER;
    private static String DB_CONNECTION;
    private static String DB_USER;
    private static String DB_PASSWORD;
    private static DBConnection single_instance = null;

    private DBConnection() {
        DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_CONNECTION = "jdbc:mysql://localhost:3306/schoolapp";
        DB_USER = "root";
        DB_PASSWORD = "";
    }

    public static synchronized DBConnection getInstance() {
        if (single_instance == null)
            single_instance = new DBConnection();
        return single_instance;
    }

    public static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            dbConnection.setAutoCommit(false);
        } catch (SQLException e) {
        }
        return dbConnection;
    }
}