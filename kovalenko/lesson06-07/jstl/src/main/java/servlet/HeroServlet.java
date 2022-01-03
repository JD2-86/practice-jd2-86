package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Ability;
import model.Gender;
import model.Hero;
import service.AbilityService;
import service.HeroService;
import service.impl.AbilityServiceImpl;
import service.impl.HeroServiceImpl;

import java.io.IOException;

@WebServlet(name = "HeroServlet", value = "/hero")
public class HeroServlet extends HttpServlet {
    private final HeroService heroService = HeroServiceImpl.getInstance();
    private final AbilityService abilityService = AbilityServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("hero", heroService.getById(Long.parseLong(id)));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/hero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Псевдоним");
        String identity = request.getParameter("Реальное имя");
        int age = Integer.parseInt(request.getParameter("Возраст"));
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        Ability ability = abilityService.getAbilities().get(Integer.parseInt(request.getParameter("ability")));
        Hero hero = new Hero(name, identity, age, gender, ability);
        heroService.add(hero);
        request.setAttribute("hero", hero);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/hero.jsp").forward(request, response);
    }
}
