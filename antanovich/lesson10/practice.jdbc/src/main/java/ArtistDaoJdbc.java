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
    public Artist addArtist(Artist artist) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO jdbc.artist (name, country) VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.setString(2, artist.getCountry());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    artist.setArtist_id(generatedKeys.getInt("artist_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public void deleteArtist(Artist artist) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM jdbc.artist WHERE name = ?;",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, artist.getArtist_id());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedKeys.getInt("artist_id");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    @Override
    public Artist updateArtist(Artist artist) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE jdbc.artist SET name = ?,  country = ? WHERE " +
                            "artist_id = ?;", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.setString(2, artist.getCountry());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    artist.setArtist_id(generatedKeys.getInt("artist_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public Artist findArtistById(int id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM jdbc.artist WHERE artist_id = ?;")) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Artist(resultSet.getString("name"),
                            resultSet.getString("country"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public Artist findArtistByName(String name) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM jdbc.artist WHERE name = ?;")) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Artist(resultSet.getString("name"),
                            resultSet.getString("country"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }
}
