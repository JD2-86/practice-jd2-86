public class Artist {
    private int artist_id;
    private String name;
    private String country;

    public Artist() {
    }

    public Artist(String name, String country) {
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
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

    @Override
    public String toString() {
        return "Artist{" +
                "artist_id=" + artist_id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
