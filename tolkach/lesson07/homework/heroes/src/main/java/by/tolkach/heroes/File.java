package by.tolkach.heroes;

import jakarta.servlet.http.HttpServletRequest;

public class File {

    protected String getListOfHeroes(HttpServletRequest request) {
        return request.getSession()
                .getServletContext()
                .getRealPath("WEB-INF/list-of-heroes.txt");
    }
    protected String getAbilities(HttpServletRequest request) {
        return request.getSession()
                .getServletContext()
                .getRealPath("WEB-INF/abilities.txt");
    }
}
