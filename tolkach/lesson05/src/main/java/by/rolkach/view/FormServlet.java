package by.rolkach.view;

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
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<form action=\"/view/api/users\" method=\"POST\">\t\t\n" +
                    "        ID: <input name=\"id\"/><br><br>" +
                    "        Name: <input name=\"firstName\"/>\n" +
                    "        <br><br>\n" +
                    "        LastName: <input name=\"lastName\"/>\n" +
                    "        <br><br>\n" +
                    "        UserName: <input name=\"userName\"/>\n" +
                    "        <br><br>\n" +
                    "\t\tPassword: <input name=\"password\"/>\n" +
                    "        <br><br>\n" +
                    "\t\temail: <input name=\"email\"/>\n" +
                    "        <br><br>\n" +
                    "        <input type=\"submit\" value=\"Submit\" />\n" +
                    "    </form>");
        }
    }
}
