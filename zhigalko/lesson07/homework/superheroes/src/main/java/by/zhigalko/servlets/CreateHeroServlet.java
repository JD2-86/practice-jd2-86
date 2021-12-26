package by.zhigalko.servlets;

import by.zhigalko.access_to_DB.AccessToAbilityStorage;
import by.zhigalko.access_to_DB.AccessToHeroStorage;
import by.zhigalko.entity.Ability;
import by.zhigalko.entity.Gender;
import by.zhigalko.entity.SuperHero;
import by.zhigalko.storage.AbilityStorage;
import by.zhigalko.storage.HeroStorage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/hero/create")
public class CreateHeroServlet extends HttpServlet implements AccessToHeroStorage, AccessToAbilityStorage {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbilityStorage ability_db = getAccessToAbilityStorage();
        request.setAttribute("ability_storage", ability_db);
        HeroStorage hero_db = getAccessToHeroStorage();
        request.setAttribute("hero_storage", hero_db);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-hero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = request.getParameter("nickname");
        String true_name = request.getParameter("true_name");
        int age = Integer.parseInt(request.getParameter("age"));
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        String abilityName = request.getParameter("select_abilities");

        AbilityStorage ability_db = getAccessToAbilityStorage();
        Ability ability = ability_db.getAbilityByName(abilityName);
        request.setAttribute("ability_storage", ability_db);

        SuperHero newHero = new SuperHero(nickname, true_name, gender, age, ability);
        HeroStorage hero_db = getAccessToHeroStorage();
        hero_db.putSuperHeroIntoDB(newHero);
        request.setAttribute("hero_storage", hero_db);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/heroes.jsp").forward(request, response);
    }
}



