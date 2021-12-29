package by.shcharbunou.usermanagementwebapplication.servlets.task3;

import by.shcharbunou.usermanagementwebapplication.entities.User;
import by.shcharbunou.usermanagementwebapplication.repositories.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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
