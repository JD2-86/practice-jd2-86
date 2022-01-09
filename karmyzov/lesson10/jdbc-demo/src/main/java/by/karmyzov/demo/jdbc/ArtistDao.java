package by.karmyzov.demo.jdbc;

public interface ArtistDao {
    /**
     * @param artist
     * @return
     */
    Artist save(Artist artist);
    Artist findById(long id);
    Artist findByName(String name);
}
