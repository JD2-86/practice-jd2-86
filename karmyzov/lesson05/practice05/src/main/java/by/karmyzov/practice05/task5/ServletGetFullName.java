package by.karmyzov.practice05.task5;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletGetFullName", value = "/full-name")
public class ServletGetFullName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String surname = (String) session.getAttribute("surname");

        try (PrintWriter writer = response.getWriter()) {
            writer.write("<h2>Get user data in session</h2>");
            writer.write("<h4>Name: " + name + "</h4>"
                    + "<h4>Surname: " + surname + "</h4>");
        }
    }
}