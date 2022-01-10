package dao;

import model.Song;

public class SongDaoImpl implements SongDao {
    private static final SongDao INSTANCE = new SongDaoImpl();

    @Override
    public Song add(Song song) {
        return null;
    }

    private SongDaoImpl(){}

    public static SongDao getInstance(){
        return INSTANCE;
    }
}
