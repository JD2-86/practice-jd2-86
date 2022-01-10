public interface ArtistSongLinkDao {
    void addArtistSong();

    void deleteArtistSong();

    void updateArtistSong();

    void findArtistBySong(String title);

    void findSongByArtist(String name);
}
