package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/student_management";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "1234";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}