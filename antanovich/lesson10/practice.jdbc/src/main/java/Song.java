public class Song {
    private int song_id;
    private String title;
    private String album;
    private int recorded;
    private String length;

    public Song() {
    }

    public Song(String title, String album, int recorded, String length) {
        this.title = title;
        this.album = album;
        this.recorded = recorded;
        this.length = length;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
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
    public String toString() {
        return "Song{" +
                "song_id=" + song_id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", recorded=" + recorded +
                ", length='" + length + '\'' +
                '}';
    }
}
