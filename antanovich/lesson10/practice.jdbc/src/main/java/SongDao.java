import java.util.List;

public interface SongDao {
    Song saveSong(Song song);

    void deleteSong(Song song);

    Song updateSong(Song song);

    Song findSongByID(int id);

    Song findSongByTitle(String title);

    List<Song> findAllSongs(Artist name);
}
