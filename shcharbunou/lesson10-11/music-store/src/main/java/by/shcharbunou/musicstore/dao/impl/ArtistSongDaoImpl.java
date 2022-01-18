package by.shcharbunou.musicstore.dao.impl;

import by.shcharbunou.musicstore.dao.ArtistSongDao;
import by.shcharbunou.musicstore.dao.connection.ConnectionManager;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;

import java.sql.*;

public class ArtistSongDaoImpl implements ArtistSongDao {
    private static ArtistSongDaoImpl instance = null;

    private ArtistSongDaoImpl() {
    }

    public static ArtistSongDaoImpl getInstance() {
        ArtistSongDaoImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (ArtistSongDaoImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ArtistSongDaoImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public boolean save(Artist artist, Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "INSERT INTO course_java_data_persistence.dao.artist_song_link " +
                    "VALUES (?, ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, song.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean deleteSong(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            String sql = "DELETE " +
                    "FROM course_java_data_persistence.dao.artist_song_link " +
                    "WHERE song_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, song.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean deleteArtist(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            String sql = "DELETE " +
                    "FROM course_java_data_persistence.dao.artist_song_link " +
                    "WHERE artist_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean update(Artist artist, Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            String sql = "UPDATE course_java_data_persistence.dao.artist_song_link " +
                    "SET artist_id = ?, song_id = ? " +
                    "WHERE artist_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, song.getId());
                preparedStatement.setLong(3, artist.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public String findArtistAndSong(Artist artist, Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        String artistSongPair = "";
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT a.name, s.title " +
                    "FROM course_java_data_persistence.dao.artist_song_link AS asl " +
                    "JOIN course_java_data_persistence.dao.artist AS a ON asl.artist_id = a.artist_id " +
                    "JOIN course_java_data_persistence.dao.song AS s ON asl.song_id = s.song_id " +
                    "WHERE asl.artist_id = ? AND asl.song_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, song.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    artistSongPair = resultSet.getString("name") + " | "
                            + resultSet.getString("title");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return artistSongPair;
    }

    @Override
    public Long findIdByTitle(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Long id = null;
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT artist_id " +
                    "FROM course_java_data_persistence.dao.artist_song_link " +
                    "WHERE song_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, song.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return id;
    }
}
