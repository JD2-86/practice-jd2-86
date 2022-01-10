package dao;

import model.Artist;

public class ArtistDaoImpl implements ArtistDao {
    private static final ArtistDao INSTANCE = new ArtistDaoImpl();

    @Override
    public Artist add(Artist artist) {
        return artist;
    }

    private ArtistDaoImpl(){}

    public static ArtistDao getInstance(){
        return INSTANCE;
    }
}
