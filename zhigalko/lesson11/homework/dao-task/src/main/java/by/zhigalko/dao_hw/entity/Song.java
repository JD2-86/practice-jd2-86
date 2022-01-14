package by.zhigalko.dao_hw.entity;

import java.util.Objects;

public class Song {
    private long id;
    private String title;
    private String album;
    private int recorded;
    private String length;

    public Song(String title, String album, int recorded, String length) {
        this.title = title;
        this.album = album;
        this.recorded = recorded;
        this.length = length;
    }

    public Song(long id, String title, String album, int recorded, String length) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.recorded = recorded;
        this.length = length;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getRecorded() {
        return recorded;
    }

    public void setRecorded(int recorded) {
        this.recorded = recorded;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && recorded == song.recorded && Objects.equals(title, song.title) && Objects.equals(album, song.album)
                && Objects.equals(length, song.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, album, recorded, length);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", recorded=" + recorded +
                ", length='" + length + '\'' +
                '}';
    }
}
