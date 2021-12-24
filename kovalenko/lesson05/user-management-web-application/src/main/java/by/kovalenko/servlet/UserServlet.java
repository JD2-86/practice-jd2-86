package by.kovalenko.servlet;

import by.kovalenko.exception.UserNotFoundException;
import by.kovalenko.model.User;
import by.kovalenko.service.UserService;
import by.kovalenko.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/view/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        Long id = null;
        try {
            id = Long.parseLong(request.getPathInfo().substring(1));
            if (id < 0) {
                throw new UserNotFoundException();
            }
            User user = userService.getById(id);
            writer.write("user info: " + user);
            response.setContentType("text/html");
        } catch (UserNotFoundException e) {
            response.setStatus(404);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }
}
