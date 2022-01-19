import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATA_DRIVER = "org.postgresql.Driver";
    private static final String DATA_URL = "jdbc:postgresql://localhost:5432/course_java_data_persistence";
    private static final String DATA_USER = "paramonov";
    private static final String DATA_PASSWORD = "12345678";

    private static Connection connection = null;

    public ConnectionManager() {
        try {
            Class.forName(DATA_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("adsutnichae classDriver");
        }
    }

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(DATA_URL, DATA_USER, DATA_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
