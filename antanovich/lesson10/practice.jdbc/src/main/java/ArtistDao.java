public interface ArtistDao {
    Artist addArtist(Artist artist);

    void deleteArtist(Artist artist);

    Artist updateArtist(Artist artist);

    Artist findArtistById(int id);

    Artist findArtistByName(String name);
}
