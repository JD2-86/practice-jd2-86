package by.rolkach.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class for getting information from FormServlet.
 * Sends information to UserFinderWriter.
 * Shows new user's information.
 */

@WebServlet(urlPatterns = "/api/users")
public class NewUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Viewer viewer = new Viewer();
        UsersFinderWriter usersFinderWriter = new UsersFinderWriter();

        resp.setContentType("text/html");

        String id = usersFinderWriter.getID();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String[] line = {id, firstName, lastName, userName, email, password};


        usersFinderWriter.writeUser(line,req);
        try (PrintWriter writer = resp.getWriter()) {
            writer.println(viewer.getText(line));
        }
    }
}
