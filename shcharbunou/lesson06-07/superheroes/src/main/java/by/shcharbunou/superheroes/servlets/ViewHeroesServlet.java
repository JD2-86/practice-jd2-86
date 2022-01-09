package by.shcharbunou.superheroes.servlets;

import by.shcharbunou.superheroes.repositories.HeroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ViewHeroesServlet", value = "/heroes")
public class ViewHeroesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeroRepository heroRepository = new HeroRepository();
        request.setAttribute("heroes", heroRepository);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-heroes.jsp").forward(request, response);
    }
}
