package by.shcharbunou.musicstore.dao;

import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;

public interface ArtistSongDao {
    boolean save(Artist artist, Song song) throws DatabaseException;

    boolean deleteSong(Song song) throws DatabaseException;

    boolean deleteArtist(Artist artist) throws DatabaseException;

    boolean update (Artist artist, Song song) throws DatabaseException;

    String findArtistAndSong(Artist artist, Song song) throws DatabaseException;

    Long findIdByTitle (Song song) throws DatabaseException;
}
