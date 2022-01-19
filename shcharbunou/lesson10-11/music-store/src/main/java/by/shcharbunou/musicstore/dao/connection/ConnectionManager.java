package by.shcharbunou.musicstore.dao.connection;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATASOURCE_URL = "jdbc:postgresql://jd2-86.cmgdvs7pj9sv.us-east-1.rds.amazonaws.com:5432/course_java_data_persistence";
    private static final String DATASOURCE_USER = "postgres";
    private static final String DATASOURCE_PASSWORD = "12345678";
    private static ConnectionManager instance = null;

    private ConnectionManager() {}

    public static ConnectionManager getInstance() {
        ConnectionManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConnectionManager();
                }
            }
        }
        return localInstance;
    }

    public Connection getConnection() throws SQLException {
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setURL(DATASOURCE_URL);
        source.setUser(DATASOURCE_USER);
        source.setPassword(DATASOURCE_PASSWORD);
        return source.getConnection();
    }
}
