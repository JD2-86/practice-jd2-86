package by.zhigalko.dao_hw.dao;

import by.zhigalko.dao_hw.connection.ConnectionManager;
import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class SongDaoImpl implements SongDao {
    private static volatile SongDaoImpl instance = null;

    public static SongDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SongDaoImpl.class) {
                if (instance == null) {
                    instance = new SongDaoImpl();
                }
            }
        }
        return instance;
    }

    private SongDaoImpl() {}

    @Override
    public Song save(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO dao.song(title,album,recorded,length) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, song.getTitle());
                preparedStatement.setString(2, song.getAlbum());
                preparedStatement.setInt(3, song.getRecorded());
                preparedStatement.setString(4, song.getLength());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    song.setId(generatedKeys.getLong(1));
                    return song;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public Song findByTitle(String title) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM dao.song WHERE title = ?;")) {
                preparedStatement.setString(1, title);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Song(resultSet.getLong("song_id"),
                            resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt(4),
                            resultSet.getString("length"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public Map<Long, Song> findAllSongs(long page, long pageSize) throws DatabaseException {
        Map<Long, Song> songMap = new HashMap<>();
        AtomicLong counter = new AtomicLong((page - 1) * pageSize);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT song.title,song.album, song.recorded, song.length " +
                            "FROM dao.song " +
                            "LIMIT ?" +
                            "OFFSET ?")) {
                preparedStatement.setLong(1, pageSize);
                preparedStatement.setLong(2, (page - 1) * pageSize);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    songMap.put(counter.incrementAndGet(), new Song(counter.get(), resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length")));
                }
                return songMap;
            }
        }  catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public Map<Long, Song> findAllSongsByArtist(Artist artist, long page, long pageSize) throws DatabaseException {
        Map<Long, Song> songMap = new HashMap<>();
        AtomicLong counter = new AtomicLong((page - 1) * pageSize);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT s.title, s.album, s.recorded, s.length " +
                            "FROM dao.song AS s " +
                            "JOIN dao.artist_song_link AS asl ON s.song_id = asl.song_id " +
                            "JOIN dao.artist AS a ON asl.artist_id = a.artist_id " +
                            "WHERE a.artist_id = ? " +
                            "LIMIT ? " +
                            "OFFSET ? ")) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, pageSize);
                preparedStatement.setLong(3, (page - 1) * pageSize);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    songMap.put(counter.incrementAndGet(), new Song(counter.get(), resultSet.getString("title"),
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
    public boolean delete(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM dao.song WHERE title = ?;")) {
                preparedStatement.setString(1, song.getTitle());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return false;
    }

    @Override
    public Song update(Song song, String newTitle, String newAlbum, int newRecorded, String newLength) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE dao.song SET title = ?, album = ?, recorded = ?, length = ?" +
                            "WHERE song_id = ?;", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, newTitle);
                preparedStatement.setString(2, newAlbum);
                preparedStatement.setInt(3, newRecorded);
                preparedStatement.setString(4, newLength);
                preparedStatement.setLong(5, song.getId());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return new Song(resultSet.getLong("song_id"),
                            resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public int countSongs() throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT count(*) " +
                            "FROM dao.song;")) {
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
    public int countSongsByArtist(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT count(*)\n " +
                            "FROM dao.song AS s " +
                            "         JOIN dao.artist_song_link AS asl ON s.song_id = asl.song_id " +
                            "         JOIN dao.artist AS a ON asl.artist_id = a.artist_id " +
                            "WHERE a.artist_id = ?;")) {
                preparedStatement.setLong(1, artist.getId());
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
}
