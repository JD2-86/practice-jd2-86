package by.shcharbunou.musicstore.dao;

import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;

import java.util.Map;

public interface SongDao {
    Song save(Song song) throws DatabaseException;

    Song findByTitle(String title) throws DatabaseException;

    Map<Long, Song> findAllSongs(long page, long pageSize) throws DatabaseException;

    Map<Long, Song> findAllSongsByArtist(Artist artist, long page, long pageSize) throws DatabaseException;

    boolean delete(Song song) throws DatabaseException;

    Song update (Song song, String newTitle, String newAlbum, int newRecorded, String newLength) throws DatabaseException;

    int countSongs() throws DatabaseException;

    int countSongsByArtist(Artist artist) throws DatabaseException;
}
