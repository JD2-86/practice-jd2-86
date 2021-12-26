package by.tolkach.heroes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/abilities")
public class Abilities extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        File file = new File();
        Integer id = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file.getAbilities(req)))) {
            String result = reader.readLine();
            while (result != null) {
                req.setAttribute("abil" + id, result);
                result = reader.readLine();
                id++;
            }
            req.setAttribute("Count", id);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String path = "/WEB-INF/jsp/abilities.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
