package model;

import java.util.Objects;

public class Song {
    private String title;
    private String album;
    private Integer recorded;
    private String length;
    private String artist;

    public Song(String title, String album, Integer recorded, String length, String artist) {
        this.title = title;
        this.album = album;
        this.recorded = recorded;
        this.length = length;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getRecorded() {
        return recorded;
    }

    public void setRecorded(Integer recorded) {
        this.recorded = recorded;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(album, song.album) && Objects.equals(recorded, song.recorded) && Objects.equals(length, song.length) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, album, recorded, length, artist);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", recorded=" + recorded +
                ", length='" + length + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
