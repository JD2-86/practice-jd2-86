import dao.ArtistDao;
import dao.ArtistDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    private static final String DATASOURCE_URL = "jdbc:postgresql://localhost:5432/course_java_data_persistence?currentSchema=jdbc";
    private static final String DATASOURCE_USER = "kovalenko";
    private static final String DATASOURCE_PASSWORD = "12345678";
    private final ArtistDao artistDao = ArtistDaoImpl.getInstance();

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jdbc.artist(name, country) VALUES (?, ?)");
            preparedStatement.setString(1, "Metallica");
            preparedStatement.setString(2, "USA");
            int count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
