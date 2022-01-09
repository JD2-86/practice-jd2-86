package by.shcharbunou.superheroes.servlets;

import by.shcharbunou.superheroes.repositories.AbilityRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ViewAbilitiesServlet", value = "/abilities")
public class ViewAbilitiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbilityRepository abilityRepository = new AbilityRepository();
        request.setAttribute("abilities", abilityRepository);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-abilities.jsp").forward(request, response);
    }
}
