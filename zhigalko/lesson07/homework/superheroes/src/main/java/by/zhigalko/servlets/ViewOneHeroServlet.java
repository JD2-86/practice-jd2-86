package by.zhigalko.servlets;

import by.zhigalko.access_to_DB.AccessToHeroStorage;
import by.zhigalko.entity.SuperHero;
import by.zhigalko.storage.HeroStorage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hero")
public class ViewOneHeroServlet extends HttpServlet implements AccessToHeroStorage {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_name = request.getParameter("id");
        long id = Long.parseLong(id_name);
        HeroStorage hero_db = getAccessToHeroStorage();
        if (hero_db.findSuperHeroInDB(id)) {
            SuperHero hero = hero_db.getSuperHeroFromDB(id);
            request.setAttribute("hero", hero);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/hero.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
