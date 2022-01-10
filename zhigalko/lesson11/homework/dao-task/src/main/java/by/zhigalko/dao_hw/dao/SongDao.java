package by.zhigalko.dao_hw.dao;

import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import java.util.Map;

public interface SongDao {
    /**
     * Allow save, find, delete and update entity in database
     * @param song
     * @return entity Song
     */
    Song save(Song song) throws DatabaseException;

    Song findByTitle(String title) throws DatabaseException;

    Map<Long, Song> findAllSongs(long page, long pageSize) throws DatabaseException;

    Map<Long, Song> findAllSongsByArtist(Artist artist, long page, long pageSize) throws DatabaseException;

    boolean delete(Song song) throws DatabaseException;

    Song update (Song song, String newTitle, String newAlbum, int newRecorded, String newLength) throws DatabaseException;

    int countSongs() throws DatabaseException;

    int countSongsByArtist(Artist artist) throws DatabaseException;
}
