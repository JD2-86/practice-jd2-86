package by.zhigalko.dao_hw.dao;

import by.zhigalko.dao_hw.connection.ConnectionManager;
import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistSongLinkDaoImpl implements ArtistSongLinkDao{
    private static volatile ArtistSongLinkDaoImpl instance = null;

    public static ArtistSongLinkDaoImpl getInstance() {
        if (instance == null) {
            synchronized (ArtistSongLinkDaoImpl.class) {
                if (instance == null) {
                    instance = new ArtistSongLinkDaoImpl();
                }
            }
        }
        return instance;
    }

    private ArtistSongLinkDaoImpl(){}

    @Override
    public boolean save(Artist artist, Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO dao.artist_song_link(artist_id, song_id) VALUES (?, ?);")) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, song.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public boolean deleteSong(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM dao.artist_song_link WHERE song_id = ?;")) {
                preparedStatement.setLong(1, song.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public boolean deleteArtist(Artist artist) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM dao.artist_song_link WHERE artist_id = ?;")) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public boolean update(Artist artist, Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE dao.artist_song_link SET artist_id = ?, song_id = ? WHERE song_id = ?;")) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, song.getId());
                preparedStatement.setLong(3, song.getId());
                preparedStatement.executeUpdate();
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public String findArtistAndSong(Artist artist, Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT a.name, s.title " +
                            "FROM dao.artist AS a " +
                            "JOIN dao.artist_song_link AS asl ON a.artist_id = asl.artist_id " +
                            "JOIN dao.song AS s ON asl.song_id = s.song_id " +
                            "WHERE asl.artist_id = ? AND asl.song_id = ?;")) {
                preparedStatement.setLong(1, artist.getId());
                preparedStatement.setLong(2, song.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return  resultSet.getString("name") + " : " +
                            resultSet.getString("title");
                }
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public Long findIdByTitle(Song song) throws DatabaseException {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        try(Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT artist_id FROM dao.artist_song_link WHERE song_id = ?;")) {
                preparedStatement.setLong(1, song.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DatabaseException();
        }
        return null;
    }
}
