package by.shcharbunou.superheroes.servlets;

import by.shcharbunou.superheroes.entities.Ability;
import by.shcharbunou.superheroes.entities.Gender;
import by.shcharbunou.superheroes.entities.Hero;
import by.shcharbunou.superheroes.repositories.AbilityRepository;
import by.shcharbunou.superheroes.repositories.HeroRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateHeroServlet", value = "/hero/create")
public class CreateHeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbilityRepository abilityRepository = new AbilityRepository();
        HeroRepository heroRepository = new HeroRepository();
        request.setAttribute("abilities", abilityRepository);
        request.setAttribute("heroes", heroRepository);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-hero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = request.getParameter("name");
        String realName = request.getParameter("identity");
        int age = Integer.parseInt(request.getParameter("age"));
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        String abilityDesignation = request.getParameter("ability");

        AbilityRepository abilityRepository = new AbilityRepository();
        Ability ability = abilityRepository.getAbilityByDesignation(abilityDesignation);

        Hero newHero = new Hero(nickname, realName, age, gender, ability);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(newHero);

        request.setAttribute("abilities", abilityRepository);
        request.setAttribute("heroes", heroRepository);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-heroes.jsp").forward(request, response);
    }
}
