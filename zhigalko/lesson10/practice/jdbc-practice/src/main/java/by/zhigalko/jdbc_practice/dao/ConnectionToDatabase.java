package by.zhigalko.jdbc_practice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {
    private static final String DATASOURCE_URL = "jdbc:postgresql://localhost:5432/course_java_data_persistence?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String DATASOURCE_USER = "postgres";
    private static final String DATASOURCE_PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD);
        } catch (
                ClassNotFoundException |
                        SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}