package by.tolkach.heroes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/create-hero")
public class HeroCreator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListOfHeroes listOfHeroes = new ListOfHeroes();
        Map<Integer, Hero> map = listOfHeroes.readHeroes(req);

        for (Integer i = 0; i < map.size(); i++) {
            req.setAttribute("Ability" + i,map.get(i).getAbility());
        }
        req.setAttribute("CountOfHeroes", map.size());

        String path = "/WEB-INF/jsp/creator.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
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

        String path = "/WEB-INF/jsp/creator.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
