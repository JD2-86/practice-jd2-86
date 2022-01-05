package by.karmyzov.practice05.task4;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet(name = "ServletSaveOnSession", value = "/send-name")
public class ServletSaveOnSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        if(name.isEmpty()|| surname.isEmpty()){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/nameSurname.jsp");
            requestDispatcher.forward(request, response);
        } else {
            session.setAttribute("name",name);
            session.setAttribute("surname", surname);
            response.setContentType("text/html");
            try(PrintWriter writer = response.getWriter()){
                writer.write("<h2>Save next user data in session</h2>");
                writer.write("<h4>Name: " + session.getAttribute("name") + "</h4>"
                        + "<h4>Surname: " + session.getAttribute("surname") + "</h4>");
            }
        }
    }
}