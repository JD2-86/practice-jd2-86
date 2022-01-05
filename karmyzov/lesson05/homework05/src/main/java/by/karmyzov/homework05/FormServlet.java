package by.karmyzov.homework05;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class which contains view form for creating users.
 */

@WebServlet(urlPatterns = "/command/create-user")
public class FormServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Viewer viewer = new Viewer();

        resp.setContentType("text/html");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println(viewer.getForm());
        }
    }
}