package by.antanovich.webservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetUser", value = "/view/users/*")
public class GetUser extends HttpServlet {

    UserDB db = new UserDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] params = req.getRequestURI().split("/");
        String userId = params[params.length-1];
        long id = Long.parseLong(userId);
        resp.setContentType("text/html");

        try (PrintWriter writer = resp.getWriter()) {
            if (id <= 0.0) {
                writer.write("<h2>Try another id</h2>");
            } else if (id > 0 && db.findUserById(id)) {
                    User user = db.getUserById(id);
                    writer.write("<h2>User:</h2>");
                    writer.write("<p> Id: " + id + "</p>");
                    writer.write("<p> FirstName: " + user.getFirstName() + "</p>");
                    writer.write("<p> Lastname: " + user.getLastName() + "</p>");
                    writer.write("<p> E-mail: " + user.getEmail() + "</p>");
                    writer.write("<p> Nickname: " + user.getUsername() + "</p>");
            } else {
                writer.write("<h2>There is no user with such id</h2>");
            }
        }
    }
}
