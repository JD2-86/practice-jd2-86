package by.karmyzov.demo.jdbc;

public class Song {
    private long id;
    private String title;
    private int length;
    private Artist artist;

    public Song(long id, String title, int length, Artist artist) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", artist=" + artist +
                '}';
    }
}