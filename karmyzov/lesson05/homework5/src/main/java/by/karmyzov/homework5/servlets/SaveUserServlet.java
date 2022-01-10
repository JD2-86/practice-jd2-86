package by.karmyzov.homework5.servlets;

import by.karmyzov.homework5.entities.User;
import by.karmyzov.homework5.repsitories.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SaveUserServlet", value = "/api/users")
public class SaveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        UserRepository db = UserRepository.getInstance();
        User newUser = new User(db.getCounter().incrementAndGet(), firstName, lastName, email, userName, password);
        db.putUserIntoDB(db.getCounter().get(), newUser);
        resp.sendRedirect(req.getContextPath() + "/view/users/?id=" + db.getCounter().toString());
    }
}