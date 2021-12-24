package by.kovalenko.servlet;

import by.kovalenko.exception.UserNotFoundException;
import by.kovalenko.model.User;
import by.kovalenko.repo.UserRepo;
import by.kovalenko.repo.impl.UserRepoImpl;
import by.kovalenko.service.UserService;
import by.kovalenko.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/users")
public class ApiServlet extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        userService.add(new User(firstName, lastName, email, userName, password));
        PrintWriter writer = response.getWriter();
        try {
            writer.write("user info: " + userService.getById((long) userService.getUsers().size()));
            response.setContentType("text/html");
        } catch (UserNotFoundException e) {
            response.setStatus(404);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }
}
