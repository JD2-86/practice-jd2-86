package by.zhigalko.servlets;

import by.zhigalko.access_to_DB.AccessToHeroStorage;
import by.zhigalko.storage.HeroStorage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ViewHeroesServlet", value = "/heroes")
public class ViewHeroesServlet extends HttpServlet implements AccessToHeroStorage {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeroStorage hero_db = getAccessToHeroStorage();
        request.setAttribute("hero_storage",hero_db);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/heroes.jsp").forward(request,response);
    }
}
