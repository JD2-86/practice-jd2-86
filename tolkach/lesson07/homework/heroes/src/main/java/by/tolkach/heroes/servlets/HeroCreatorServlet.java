package by.tolkach.heroes.servlets;

import by.tolkach.heroes.dto.Hero;
import by.tolkach.heroes.dto.ListOfHeroes;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-hero")
public class HeroCreatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        showPage(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hero hero = new Hero();
        ListOfHeroes listOfHeroes = new ListOfHeroes();
        hero.setLogin(req.getParameter("login"));
        hero.setName(req.getParameter("name"));
        hero.setAge(req.getParameter("age"));
        hero.setMale(req.getParameter("male"));
        hero.setAbility(req.getParameter("abil"));
        listOfHeroes.writeHero(hero,req);
        showPage(req,resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ListOfHeroes listOfHeroes = new ListOfHeroes();
        req.setAttribute("abilities",listOfHeroes.listOfAbilities(req));
        String path = "/WEB-INF/jsp/creator.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).include(req,resp);
    }
}
