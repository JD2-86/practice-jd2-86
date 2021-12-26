package by.tolkach.heroes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/list")
public class Heroes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListOfHeroes listOfHeroes = new ListOfHeroes();
        Map<Integer, Hero> map = listOfHeroes.readHeroes(req);

        for (Integer i = 0; i < map.size(); i++) {
            req.setAttribute("log" + i,map.get(i).getLogin());
        }
        req.setAttribute("CountOfHeroes", map.size());

        String path = "/WEB-INF/jsp/heroes.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
