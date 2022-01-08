package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AbilityInitializer;
import service.HeroInitializer;
import service.HeroService;
import service.impl.AbilityInitializerImpl;
import service.impl.HeroInitializerImpl;
import service.impl.HeroServiceImpl;

import java.io.IOException;

@WebServlet(name = "HeroesServlet", value = "/heroes")
public class HeroesServlet extends HttpServlet {
    private final AbilityInitializer abilityInitializer = AbilityInitializerImpl.getInstance();
    private final HeroInitializer heroInitializer = HeroInitializerImpl.getInstance();
    private final HeroService heroService = HeroServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        abilityInitializer.init();
        heroInitializer.init();
        request.setAttribute("heroes", heroService.getHeroes());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/heroes.jsp").forward(request, response);
    }
}
