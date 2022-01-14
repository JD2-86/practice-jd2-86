package by.zhigalko.dao_hw.dao;

import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;

public interface ArtistSongLinkDao {
    /**
     * Allow save, delete and update data in link table
     * @param artist
     * @param song
     * @return number of participant's rows in the request
     */
    boolean save(Artist artist, Song song) throws DatabaseException;

    boolean deleteSong(Song song) throws DatabaseException;

    boolean deleteArtist(Artist artist) throws DatabaseException;

    boolean update (Artist artist, Song song) throws DatabaseException;

    String findArtistAndSong(Artist artist, Song song) throws DatabaseException;

    Long findIdByTitle (Song song) throws DatabaseException;
}
