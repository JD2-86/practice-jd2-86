package by.karmyzov.demo.jdbc;

import java.sql.*;

public class ConnectioDatabasedemo {
    private static final String URL = "jdbc:postgresql://localhost:5432/course_java_data_persistance";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (
                ClassNotFoundException |
                        SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
//
//    {
//        Connection connection = getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeQuery("SELECT * FROM jdbc.artist");
//            ResultSet resultSet = statement.getResultSet();
//            System.out.println(resultSet);
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//    }
//
//    private static Connection getConnection() {
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
//        }
//        return connection;
//    }
//
//}
