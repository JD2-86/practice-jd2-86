package by.shcharbunou.musicstore.dao;

import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;

import java.util.List;
import java.util.Map;

public interface ArtistDao {
    Artist save(Artist artist) throws DatabaseException;

    List<Artist> findByName(String name) throws DatabaseException;

    Artist findById(Long id) throws DatabaseException;

    Map<Long, Song> findAllSongs(Artist artist) throws DatabaseException;

    Map<Long, Artist> findAllArtists(long page, long pageSize) throws DatabaseException;

    boolean delete(Artist artist) throws DatabaseException;

    Artist update(Artist artist, String updatedName, String updatedCountry) throws DatabaseException;

    int countArtist() throws DatabaseException;
}
