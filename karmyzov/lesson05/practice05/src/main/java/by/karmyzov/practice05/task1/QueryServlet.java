package by.karmyzov.practice05.task1;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "queryServlet", value = "/query-servlet")
public class QueryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            if (name == null && surname == null) {
                writer.write(" <h1> Wrong request. Don't exists name, surname </h1>");
            } else if (name == null || surname == null) {
                if (name == null) {
                    writer.write(" <h1> Wrong request. Don't exists name </h1>");
                } else {
                    writer.write(" <h1> Wrong request. Don't exists surname </h1>");
                }
            } else {
                writer.write("<h1> My name is " + name + " " + surname + "</h1>");
            }
        }
    }
}