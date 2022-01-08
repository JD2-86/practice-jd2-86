package by.tolkach.heroes.servlets;

import by.tolkach.heroes.dto.ListOfHeroes;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbilitiesServlet", value = "/abilities")
public class AbilitiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ListOfHeroes listOfHeroes = new ListOfHeroes();

        req.setAttribute("abilities",listOfHeroes.listOfAbilities(req));

        String path = "/WEB-INF/jsp/abilities.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
