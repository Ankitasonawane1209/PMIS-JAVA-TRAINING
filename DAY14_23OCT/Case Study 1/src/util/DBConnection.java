package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static final String URL = setting("JDBC_URL", "jdbc:mysql://localhost:3306/LibraryDB");
    private static final String USER = setting("JDBC_USER", "root");
    private static final String PASSWORD = setting("JDBC_PASSWORD","NewStrongPassword123!" );

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static String setting(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}
