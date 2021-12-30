package by.tolkach.heroes.dto;

import jakarta.servlet.http.HttpServletRequest;

public class File {
    protected String getListOfHeroes(HttpServletRequest request) {
        return request.getServletContext()
                .getRealPath("WEB-INF/list-of-heroes.txt");
    }
    protected String getAbilities(HttpServletRequest request) {
        return request.getServletContext()
                .getRealPath("WEB-INF/abilities.txt");
    }
}
