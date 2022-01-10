package by.zhigalko.dao_hw.dao;

import by.zhigalko.dao_hw.connection.ConnectionManager;
import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ArtistDaoImpl implements ArtistDao{
    private static volatile ArtistDaoImpl instance = null;

    public static ArtistDaoImpl getInstance() {
        if (instance == null) {
            synchronized (ArtistDaoImpl.class) {
                if (instance == null) {
                    instance = new ArtistDaoImpl();
                }
            }
        }
        return instance;
    }

    private ArtistDaoImpl(){}

    @Override
    public Artist save(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO dao.artist(name, country) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.setString(2, artist.getCountry());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    artist.setId(generatedKeys.getLong(1));
                    return artist;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public Artist findByName(String name) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM dao.artist WHERE name = ?")) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Artist(resultSet.getLong("artist_id"),
                                      resultSet.getString("name"),
                                      resultSet.getString("country"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public Artist findById(Long id) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM dao.artist WHERE artist_id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Artist(resultSet.getLong("artist_id"),
                            resultSet.getString("name"),
                            resultSet.getString("country"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public Map<Long, Song> findAllSongs(Artist artist) throws DatabaseException {
        Map<Long, Song> songMap = new HashMap<>();
        AtomicLong counter = new AtomicLong(0);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT s.song_id, s.title, s.album, s. recorded, s.length " +
                            "FROM dao.artist AS a " +
                            "         JOIN dao.artist_song_link AS asl ON a.artist_id = asl.artist_id " +
                            "         JOIN dao.song AS s ON asl.song_id = s.song_id " +
                            "WHERE a.artist_id = ?")) {
                preparedStatement.setLong(1, artist.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    songMap.put(counter.incrementAndGet(), new Song(counter.get(),
                            resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length")));
                }
                return songMap;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public int countArtist() throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT count(*) " +
                            "FROM dao.artist;")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return 0;
    }

    @Override
    public Map<Long,Artist> findAllArtists(long page, long pageSize) throws DatabaseException {
        Map<Long, Artist> artistMap = new HashMap<>();
        AtomicLong counter = new AtomicLong((page - 1) * pageSize);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT artist.name,artist.country " +
                            "FROM dao.artist " +
                            "LIMIT ?" +
                            "OFFSET ?")) {
                preparedStatement.setLong(1, pageSize);
                preparedStatement.setLong(2, (page - 1) * pageSize);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    artistMap.put(counter.incrementAndGet(), new Artist(counter.get(), resultSet.getString("name"),
                            resultSet.getString("country")));
                }
                return artistMap;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public boolean delete(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM dao.artist WHERE name = ?")) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return false;
    }

    @Override
    public Artist update(Artist artist, String new_name, String new_country) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE dao.artist SET name = ?, country = ? WHERE artist_id = ?", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, new_name);
                preparedStatement.setString(2, new_country);
                preparedStatement.setLong(3, artist.getId());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return new Artist(resultSet.getLong("artist_id"),
                                      resultSet.getString("name"),
                                      resultSet.getString("country"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }
}
