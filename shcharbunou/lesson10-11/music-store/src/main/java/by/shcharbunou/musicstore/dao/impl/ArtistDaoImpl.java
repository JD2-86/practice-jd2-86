package by.shcharbunou.musicstore.dao.impl;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.connection.ConnectionManager;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;

import java.sql.*;
import java.util.Map;

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
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO dao.artist (name, country)" +
                            "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS
            )) {
                preparedStatement.setString(1, artist.getName());
                preparedStatement.setString(2, artist.getCountry());
                preparedStatement.executeUpdate();
                ResultSet keys = preparedStatement.getGeneratedKeys();
                if (keys.next()) {
                    artist.setId(keys.getLong(1));
                    return artist;
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return new Artist();
    }

    @Override
    public Artist findByName(String name) throws DatabaseException {
        return null;
    }

    @Override
    public Artist findById(Long id) throws DatabaseException {
        return null;
    }

    @Override
    public Map<Long, Song> findAllSongs(Artist artist) throws DatabaseException {
        return null;
    }

    @Override
    public Map<Long, Artist> findAllArtists(long page, long pageSize) throws DatabaseException {
        return null;
    }

    @Override
    public boolean delete(Artist artist) throws DatabaseException {
        return false;
    }

    @Override
    public Artist update(Artist artist, String new_name, String new_country) throws DatabaseException {
        return null;
    }

    @Override
    public int countArtist() throws DatabaseException {
        return 0;
    }
}
