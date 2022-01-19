import java.sql.Connection;

public class ArtistDaoJdbc implements ArtistDao {
    private static volatile ArtistDaoJdbc INSTANCE;

    private ArtistDaoJdbc() {
    }

    public static ArtistDaoJdbc getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (ArtistDaoJdbc.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ArtistDaoJdbc();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void add(Artist artist) {
        Connection connection = ConnectionManager.getConnection();
    }
}
