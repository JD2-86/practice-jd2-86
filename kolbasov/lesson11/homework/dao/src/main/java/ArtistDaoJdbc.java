import java.sql.*;

public class ArtistDaoJdbc implements ArtistDao {


    private static final Object LOCK = new Object();
    private static ArtistDaoJdbc INSTANCE = null;

    public static ArtistDaoJdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ArtistDaoJdbc();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Artist save(Artist artist) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO artist (name, country) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.setString(2, artist.getCountry());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
              /*  if (generatedKeys.next()) {
                    artist.setId(generatedKeys.getLong(2));
                    return artist;
                }*/
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }


}
