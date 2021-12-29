package by.kovalenko.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/view/command/create-user")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<html><head>");
        writer.write("<title>Form of creation of new user</title>");
        writer.write("</head><body>");
        writer.write("<form method=\"post\" action=\"api/users\">");
        writer.write("<fieldset>");
        writer.write("<legend>Form to fill in fields</legend>");
        writer.write("<label for=\"firstName\">FirstName:</label>");
        writer.write("<input type=\"text\" id=\"firstName\" name=\"firstName\">");
        writer.write("<p><label for=\"lastName\">LastName</label>");
        writer.write("<input type=\"text\" id=\"lastName\" name=\"lastName\"></p>");
        writer.write("<p><label for=\"email\">E-mail</label>");
        writer.write("<input type=\"email\" id=\"email\" name=\"email\"></p>");
        writer.write("<p><label for=\"userName\">UserName</label>");
        writer.write("<input type=\"text\" id=\"userName\" name=\"userName\"></p>");
        writer.write("<p><label for=\"password\">Password</label>");
        writer.write("<input type=\"password\" id=\"password\" name=\"password\"></p>");
        writer.write("<p><input type=\"submit\" name=\"Send\"></p>");
        writer.write("</fieldset></form>");
        writer.write("</body></html>");
    }
}
