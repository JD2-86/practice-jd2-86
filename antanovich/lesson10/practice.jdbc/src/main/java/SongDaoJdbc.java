import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDaoJdbc implements SongDao {
    private static final Object LOCK = new Object();
    private static SongDaoJdbc INSTANCE = null;

    public static SongDaoJdbc getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new SongDaoJdbc();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Song saveSong(Song song) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO jdbc.song (title, album, recorded, length) " +
                            "VALUES (?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, song.getTitle());
                preparedStatement.setString(2, song.getAlbum());
                preparedStatement.setInt(3, song.getRecorded());
                preparedStatement.setString(4, song.getLength());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    song.setSong_id(generatedKeys.getInt("song_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public void deleteSong(Song song) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM jdbc.song WHERE title = ?;",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, song.getSong_id());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedKeys.getInt("song_id");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    @Override
    public Song updateSong(Song song) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE jdbc.song SET title = ?, album = ?, recorded = ?," +
                            " length = ? WHERE song_id = ?;",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, song.getTitle());
                preparedStatement.setString(2, song.getAlbum());
                preparedStatement.setInt(3, song.getRecorded());
                preparedStatement.setString(4, song.getLength());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    song.setSong_id(generatedKeys.getInt("song_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public Song findSongByID(int id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM jdbc.song WHERE song_id = ?;")) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Song(resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public Song findSongByTitle(String title) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM jdbc.song WHERE title = ?;")) {
                preparedStatement.setString(1, title);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Song(resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return null;
    }

    @Override
    public List<Song> findAllSongs(Artist name) {
        List<Song> songs = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM jdbc.song " +
                            "JOIN jdbc.artist_song_link ON jdbc" +
                            ".artist_song_link" +
                            ".song_id = jdbc.song.song_id " +
                            "JOIN jdbc.artist ON jdbc.artist_song_link.artist_id " +
                            "= jdbc.artist.artist_id WHERE jdbc.artist.name = ?;")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    songs.add(new Song(resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length")));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return songs;
    }
}
