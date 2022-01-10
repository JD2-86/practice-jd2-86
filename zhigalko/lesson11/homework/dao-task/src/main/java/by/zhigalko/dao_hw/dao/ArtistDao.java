package by.zhigalko.dao_hw.dao;

import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import java.util.Map;

public interface ArtistDao {
    /**
     * Allow save, find, delete and update entity in database
     * @param artist
     * @return entity Artist
     */
    Artist save(Artist artist) throws DatabaseException;

    Artist findByName(String name) throws DatabaseException;

    Artist findById(Long id) throws DatabaseException;

    Map<Long, Song> findAllSongs(Artist artist) throws DatabaseException;

    Map<Long,Artist> findAllArtists(long page, long pageSize) throws DatabaseException;

    boolean delete(Artist artist) throws DatabaseException;

    Artist update(Artist artist, String new_name, String new_country) throws DatabaseException;

    int countArtist () throws DatabaseException;
}
