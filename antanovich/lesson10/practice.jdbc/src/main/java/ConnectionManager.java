import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATASOURCE_URL = "jdbc:postgresql://localhost:5432/course_java_data_persistence/jdbc";
    private static final String DATASOURCE_USER = "postgres";
    private static final String DATASOURCE_PASSWORD = "Xotress7";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return connection;
    }
}
