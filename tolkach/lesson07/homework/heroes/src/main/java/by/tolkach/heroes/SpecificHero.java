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
        resp.setContentType("text/html");

        ListOfHeroes listOfHeroes = new ListOfHeroes();
        Map<Integer, Hero> map = listOfHeroes.readHeroes(req);

        String id = req.getPathInfo().replaceFirst("/","");

        for (Map.Entry<Integer, Hero> entry : map.entrySet()) {
            if (entry.getValue().getLogin().equals(id)) {
                req.setAttribute("log", entry.getValue().getLogin());
                req.setAttribute("name", entry.getValue().getName());
                req.setAttribute("male", entry.getValue().getMale());
                req.setAttribute("age", entry.getValue().getAge());
                req.setAttribute("abil", entry.getValue().getAbility());
                break;
            }
        }

        String path = "/WEB-INF/jsp/specific-hero.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
