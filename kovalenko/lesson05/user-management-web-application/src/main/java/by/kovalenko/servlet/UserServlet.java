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
        long id;
        try {
            id = Long.parseLong(request.getPathInfo().substring(1));
            if (id < 0) {
                throw new UserNotFoundException();
            }
            User user = userService.getById(id);
            response.setContentType("text/html");
            writer.write("<html><body>");
            writer.write("<h1> User info </h1>");
            writer.write("<p> Id: " + user.getId() + "</p>");
            writer.write("<p> FirstName: " + user.getFirstName() + "</p>");
            writer.write("<p> LastName: " + user.getLastName() + "</p>");
            writer.write("<p> Email: " + user.getEmail() + "</p>");
            writer.write("<p> UserName: " + user.getUserName() + "</p>");
            writer.write("</body></html>");
        } catch (UserNotFoundException e) {
            response.setStatus(404);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }
}
