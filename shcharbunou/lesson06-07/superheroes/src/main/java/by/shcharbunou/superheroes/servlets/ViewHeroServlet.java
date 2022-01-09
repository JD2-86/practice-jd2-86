package by.shcharbunou.superheroes.servlets;

import by.shcharbunou.superheroes.entities.Hero;
import by.shcharbunou.superheroes.repositories.HeroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ViewHeroServlet", value = "/hero")
public class ViewHeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        HeroRepository heroRepository = new HeroRepository();
        if (heroRepository.find(id)) {
            Hero hero = heroRepository.get(id);
            request.setAttribute("hero", hero);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-hero.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
