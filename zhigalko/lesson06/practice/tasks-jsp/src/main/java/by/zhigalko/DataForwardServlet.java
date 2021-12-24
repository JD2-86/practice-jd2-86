package by.zhigalko;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DataForwardServlet", value = "/data-forward")
public class DataForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try (PrintWriter writer = response.getWriter()) {
            if (firstName == null || lastName == null) {
                writer.write("<h1> Please enter firstName and lastName in query string, " +
                        "for example ?firstName=alex&lastName=smith </h1>");
            } else {
                request.setAttribute("role", "User");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/data-forward.jsp").forward(request,response);
            }
        }
    }
}
