package by.tolkach.heroes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class Heroes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Map<Integer, Hero> map = new ListOfHeroes().readHeroes(req);
        List<String> listOfLogin = new ArrayList();

        for (Map.Entry<Integer, Hero> entry : map.entrySet()) {
            listOfLogin.add(entry.getValue().getLogin());
        }

        req.setAttribute("heroes",listOfLogin);

        String path = "/WEB-INF/jsp/heroes.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
