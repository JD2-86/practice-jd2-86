import java.util.HashSet;
import java.util.Set;

public class Artist {
    private long id;
    private String name;
    private String country;
    private Set<Song> songs = new HashSet<>();

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Artist(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", songs=" + songs +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
