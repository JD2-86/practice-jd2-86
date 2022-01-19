public class Song {
    private long id;
    private String title;
    private String album;
    private int recorded;
    private int length;
    private String artist;

    public Song(long id, String title, String album, int recorded, int length, String artist) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.recorded = recorded;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", recorded=" + recorded +
                ", length=" + length +
                ", artist=" + artist +
                '}';
    }
}
