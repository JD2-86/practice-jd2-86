package by.karmyzov.practice05.task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletForOutputData", value = "/servletForOutputData")
public class ServletForOutputData extends HttpServlet {
    private static final String PARAMETER_NAME = "name";
    private static final String PARAMETER_SURNAME = "surname";
    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PHONE = "telephoneNumber";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter(PARAMETER_NAME);
        String surname = request.getParameter(PARAMETER_SURNAME);
        String email = request.getParameter(PARAMETER_EMAIL);
        String phone = request.getParameter(PARAMETER_PHONE);
        try (PrintWriter writer = response.getWriter()) {
            writer.write("User's data: ");
            writer.write("<p> Name: " + name + "</p> <p> Surname: " + surname + "</p> <p> Email: " + email + "</p> <p> Phone Number: " + phone + "<p>");
        }
    }
}