package by.shcharbunou.musicstore.dao.impl;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.connection.ConnectionManager;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ArtistDaoImpl implements ArtistDao {
    private static ArtistDaoImpl instance = null;

    private ArtistDaoImpl() {
    }

    public ArtistDaoImpl getInstance() {
        ArtistDaoImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (ArtistDaoImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ArtistDaoImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Artist save(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "INSERT INTO course_java_data_persistence.dao.artist (name, country) " +
                    "VALUES (?, ?)";
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.setString(2, artist.getCountry());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    artist.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return artist;
    }

    @Override
    public List<Artist> findByName(String name) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        List<Artist> artists = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "SELECT * " +
                    "FROM course_java_data_persistence.dao.artist " +
                    "WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    artists.add(new Artist(resultSet.getLong("artist_id"),
                            resultSet.getString("name"),
                            resultSet.getString("country")));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return artists;
    }

    @Override
    public Artist findById(Long id) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Artist artist = new Artist();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "SELECT * " +
                    "FROM course_java_data_persistence.dao.artist " +
                    "WHERE artist_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    artist.setId(resultSet.getLong("artist_id"));
                    artist.setName(resultSet.getString("name"));
                    artist.setCountry(resultSet.getString("country"));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return artist;
    }

    @Override
    public List<Song> findAllSongs(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        List<Song> songs = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "SELECT s.title, s.album, s.recorded, s.length " +
                    "FROM course_java_data_persistence.dao.artist AS a " +
                    "JOIN course_java_data_persistence.dao.artist_song_link AS asl ON a.artist_id = asl.artist_id " +
                    "JOIN course_java_data_persistence.dao.song AS s ON asl.song_id = s.song_id " +
                    "WHERE a.artist_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setLong(1, artist.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    songs.add(new Song(resultSet.getLong("song_id"),
                            resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length")));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return songs;
    }

    @Override
    public Map<Long, Artist> findAllArtists(long page, long pageSize) throws DatabaseException {
        Map<Long, Artist> artistMap = new HashMap<>();
        AtomicLong counter = new AtomicLong((page - 1) * pageSize);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "SELECT a.name, a.country " +
                    "FROM course_java_data_persistence.dao.artist AS a " +
                    "LIMIT ? " +
                    "OFFSET ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setLong(1, pageSize);
                preparedStatement.setLong(2, Long.parseLong(counter.toString()));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    artistMap.put(counter.incrementAndGet(), new Artist(counter.get(),
                            resultSet.getString("name"),
                            resultSet.getString("country")));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return artistMap;
    }

    @Override
    public boolean delete(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "DELETE " +
                    "FROM course_java_data_persistence.dao.artist " +
                    "WHERE artist_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return false;
    }

    @Override
    public Artist update(Artist artist, String updatedName, String updatedCountry) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Artist newArtist = new Artist();
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "UPDATE course_java_data_persistence.dao.artist " +
                    "SET name = ?, country = ? " +
                    "WHERE artist_id = ?";
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, updatedName);
                preparedStatement.setString(2, updatedCountry);
                preparedStatement.setLong(3, artist.getId());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getResultSet();
                if (resultSet.next()) {
                    newArtist.setId(resultSet.getLong("artist_id"));
                    newArtist.setName(resultSet.getString("name"));
                    newArtist.setCountry(resultSet.getString("country"));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return newArtist;
    }

    @Override
    public int countArtist() throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        int count = 0;
        try (Connection connection = connectionManager.getConnection()) {
            String sqlQuery = "SELECT count(*) " +
                    "FROM course_java_data_persistence.dao.artist;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return count;
    }
}
