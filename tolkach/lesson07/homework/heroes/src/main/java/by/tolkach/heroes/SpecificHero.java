package by.tolkach.heroes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/specific-hero/*")
public class SpecificHero extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListOfHeroes listOfHeroes = new ListOfHeroes();
        Map<Integer, Hero> map = listOfHeroes.readHeroes(req);

        String id = req.getPathInfo().replaceFirst("/","");
        Hero hero = map.get(Integer.parseInt(id));

        req.setAttribute("log", hero.getLogin());
        req.setAttribute("name", hero.getName());
        req.setAttribute("male", hero.getMale());
        req.setAttribute("age", hero.getAge());
        req.setAttribute("abil", hero.getAbility());

        String path = "/WEB-INF/jsp/specific-hero.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
