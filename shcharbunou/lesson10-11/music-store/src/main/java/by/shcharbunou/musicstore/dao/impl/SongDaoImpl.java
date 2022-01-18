package by.shcharbunou.musicstore.dao.impl;

import by.shcharbunou.musicstore.dao.SongDao;
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

public class SongDaoImpl implements SongDao {
    private static SongDaoImpl instance = null;

    private SongDaoImpl() {
    }

    public SongDaoImpl getInstance() {
        SongDaoImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (SongDaoImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SongDaoImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Song save(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "INSERT INTO course_java_data_persistence.dao.song " +
                    "VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, song.getTitle());
                preparedStatement.setString(2, song.getAlbum());
                preparedStatement.setInt(3, song.getRecorded());
                preparedStatement.setString(4, song.getLength());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    song.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return song;
    }

    @Override
    public List<Song> findByTitle(String title) throws DatabaseException {
        List<Song> songs = new ArrayList<>();
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT * " +
                    "FROM course_java_data_persistence.dao.song AS s " +
                    "WHERE s.title = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
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
    public Map<Long, Song> findAllSongs(long page, long pageSize) throws DatabaseException {
        Map<Long, Song> songMap = new HashMap<>();
        AtomicLong counter = new AtomicLong((page - 1) * pageSize);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT s.title, s.album, s.recorded, s.length " +
                    "FROM course_java_data_persistence.dao.song AS s " +
                    "LIMIT ? " +
                    "OFFSET ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, pageSize);
                preparedStatement.setLong(2, Long.parseLong(counter.toString()));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    songMap.put(counter.incrementAndGet(), new Song(counter.get(),
                            resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length")));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return songMap;
    }

    @Override
    public Map<Long, Song> findAllSongsByArtist(Artist artist, long page, long pageSize) throws DatabaseException {
        Map<Long, Song> songMap = new HashMap<>();
        AtomicLong counter = new AtomicLong((page - 1) * pageSize);
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT s.title, s.album, s.recorded, s.length " +
                    "FROM course_java_data_persistence.dao.song AS s " +
                    "JOIN course_java_data_persistence.dao.artist_song_link AS asl ON s.song_id = asl.song_id " +
                    "JOIN course_java_data_persistence.dao.artist AS a ON asl.artist_id = a.artist_id " +
                    "WHERE a.artist_id = ? " +
                    "LIMIT ? " +
                    "OFFSET ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, pageSize);
                preparedStatement.setLong(3, Long.parseLong(counter.toString()));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    songMap.put(counter.incrementAndGet(), new Song(counter.get(),
                            resultSet.getString("title"),
                            resultSet.getString("album"),
                            resultSet.getInt("recorded"),
                            resultSet.getString("length")));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return songMap;
    }

    @Override
    public boolean delete(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "DELETE " +
                    "FROM course_java_data_persistence.dao.song " +
                    "WHERE song_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, song.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return false;
    }

    @Override
    public Song update(Song song, String updatedTitle, String updatedAlbum, int updatedRecorded, String updatedLength) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Song updatedSong = new Song();
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "UPDATE course_java_data_persistence.dao.song " +
                    "SET title = ?, album = ?, recorded = ?, length = ? " +
                    "WHERE song_id = ?";
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, updatedTitle);
                preparedStatement.setString(2, updatedAlbum);
                preparedStatement.setInt(3, updatedRecorded);
                preparedStatement.setString(4, updatedLength);
                preparedStatement.setLong(5, song.getId());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    updatedSong.setId(resultSet.getLong("song_id"));
                    updatedSong.setTitle(resultSet.getString("title"));
                    updatedSong.setAlbum(resultSet.getString("album"));
                    updatedSong.setRecorded(resultSet.getInt("recorded"));
                    updatedSong.setLength(resultSet.getString("length"));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return updatedSong;
    }

    @Override
    public int countSongs() throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        int count = 0;
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT count(*) " +
                    "FROM course_java_data_persistence.dao.song;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

    @Override
    public int countSongsByArtist(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        int count = 0;
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT count(*) " +
                    "FROM course_java_data_persistence.dao.song AS s " +
                    "JOIN course_java_data_persistence.dao.artist_song_link AS asl ON s.song_id = asl.song_id " +
                    "JOIN course_java_data_persistence.dao.artist AS a ON asl.artist_id = a.artist_id " +
                    "WHERE a.artist_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, artist.getId());
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
