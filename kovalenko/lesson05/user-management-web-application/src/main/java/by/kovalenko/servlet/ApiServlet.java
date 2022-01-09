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
        try {
            User newUser = new User(firstName, lastName, email, userName, password);
            PrintWriter writer = response.getWriter();
            response.setContentType("text/html");
            writer.write("<html><body>");
            writer.write("<h1> User info </h1>");
            writer.write("<p> Id: " + userService.add(newUser).getId() + "</p>");
            writer.write("<p> FirstName: " + newUser.getFirstName() + "</p>");
            writer.write("<p> LastName: " + newUser.getLastName() + "</p>");
            writer.write("<p> Email: " + newUser.getEmail() + "</p>");
            writer.write("<p> UserName: " + newUser.getUserName() + "</p>");
            writer.write("</body></html>");
        } catch (UserNotFoundException e) {
            response.setStatus(404);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }
}
