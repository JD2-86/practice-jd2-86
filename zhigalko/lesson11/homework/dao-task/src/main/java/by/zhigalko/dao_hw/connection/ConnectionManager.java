package by.zhigalko.dao_hw.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATASOURCE_URL = "jdbc:postgresql://ec2-54-165-213-86.compute-1.amazonaws.com:5432/course_java_data_persistence";
    private static final String DATASOURCE_USER = "postgres";
    private static final String DATASOURCE_PASSWORD = "1234";
    private static volatile ConnectionManager instance = null;

    private ConnectionManager() {}

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException, NullPointerException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD);
    }
}
