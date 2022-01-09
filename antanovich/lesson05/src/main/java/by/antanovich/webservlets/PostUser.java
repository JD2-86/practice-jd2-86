package by.antanovich.webservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addNewUser", value = "/api/users")
public class PostUser extends HttpServlet {

        UserDB db = new UserDB();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
//?firstName=Ivan&lastName=Ivanov&email=iv@iv.com&username=ivan&password=pass
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (PrintWriter writer = resp.getWriter()) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            db.addNewUser(user);
            long id = user.getId();

            writer.write("<html>");
            writer.write("<body>");
            writer.write("<h2>User:</h2>");
            writer.write("<p> Id: " + id + "</p>");
            writer.write("<p> FirstName: " + user.getFirstName() + "</p>");
            writer.write("<p> Lastname: " + user.getLastName() + "</p>");
            writer.write("<p> E-mail: " + user.getEmail() + "</p>");
            writer.write("<p> Nickname: " + user.getUsername() + "</p>");
            writer.write("</body>");
            writer.write("</html>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
