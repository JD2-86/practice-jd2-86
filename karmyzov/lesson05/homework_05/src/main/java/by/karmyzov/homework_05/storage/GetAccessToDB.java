package by.karmyzov.homework_05.storage;

import jakarta.servlet.ServletConfig;

public interface GetAccessToDB extends ServletConfig {
    default UserStorage getAccess() {
        UserStorage db = (UserStorage) getServletContext().getAttribute("db");
        if (db == null) {
            String databaseName = getServletContext().getInitParameter("database");
            if (databaseName.equals(UserStorage.class.getName())) {
                db = new UserStorage();
                getServletContext().setAttribute("db", db);
            }
        }
        return db;
    }
}