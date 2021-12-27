package by.antanovich.webservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/view/command/create-user")
public class AddUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<form action=\"/command/create-user\" method=\"post\">");
            writer.write("<div style=\"width:300px; display:flex; justify-content:space-between;\">\n" +
                    "    <label for=\"name\">FirstName:</label>\n" +
                    "    <input type=\"text\" id=\"name\" name=\"user_name\" />\n" +
                    "    </div><br>");
            writer.write("<div style=\"width:300px; display:flex; justify-content:space-between;\">\n" +
                    "    <label for=\"surname\">Lastname:</label>\n" +
                    "    <input type=\"text\" id=\"surname\" name=\"user_surname\" />\n" +
                    "     </div><br>");
            writer.write("<div style=\"width:300px; display:flex; justify-content:space-between;\">\n" +
                    "    <label for=\"mail\">E-mail:</label>\n" +
                    "    <input type=\"email\" id=\"mail\" name=\"user_email\" />\n" +
                    "    </div><br>");
            writer.write("<div style=\"width:300px; display:flex; justify-content:space-between;\">\n" +
                    "    <label for=\"nickname\">Nickname:</label>\n" +
                    "    <input type=\"text\" id=\"nickname\" name=\"user_nickname\" />\n" +
                    "    </div><br>");
            writer.write("<div style=\"width:300px; display:flex; justify-content:space-between;\">\n" +
                    "    <label for=\"password\">Password:</label>\n" +
                    "    <input type=\"password\" id=\"password\" name=\"user_password\" />\n" +
                    "    </div><br>");
            writer.write("<br><div style=\"width:300px; display:flex; justify-content:space-around;\"> " +
                    "<input type=\"submit\" value=\"Add\" style=\"width:100px; background-color:green;\"></form></div>");
        }
    }
}