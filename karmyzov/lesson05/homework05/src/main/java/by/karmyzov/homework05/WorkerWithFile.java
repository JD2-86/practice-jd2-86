package by.karmyzov.homework05;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Class for getting file path.
 */

public class WorkerWithFile {

    protected String getListOfUsers(HttpServletRequest request) {
        return request.getSession()
                .getServletContext()
                .getRealPath("WEB-INF/ListOfUsers.txt");
    }
}