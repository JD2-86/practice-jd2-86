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
import java.util.List;

@WebServlet(urlPatterns = "/view/users")
public class UsersServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if (page < 1 || pageSize < 1) {
                throw new Exception();
            }
            if (pageSize > userService.getUsers().size()) {
                pageSize = userService.getUsers().size();
            }
            List<User> users = userService.getUsersPartition(page, pageSize);
            if (users.isEmpty()) {
                throw new UserNotFoundException();
            }
            String contextPath = request.getContextPath();
            writer.write("<html>");
            writer.write("<head>");
            writer.write("<meta charset=\"utf-8\">");
            writer.write("<table border=\"1\">User table");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<caption>User table</caption>");
            writer.write("<tr>");
            writer.write("<th>User id</th>");
            writer.write("<th>FirstName</th>");
            writer.write("<th>LastName</th>");
            writer.write("<th>Email</th>");
            writer.write("<th>UserName</th>");
            writer.write("</tr>");
            users.forEach(user -> {
                writer.write("<tr><td><a href=" + contextPath + "/view/users/" + user.getId() + "> " + user.getId() + "</a></td>");
                writer.write("<td>" + user.getFirstName() + "</td>");
                writer.write("<td>" + user.getLastName() + "</td>");
                writer.write("<td>" + user.getEmail() + "</td>");
                writer.write("<td>" + user.getUserName() + "</td></tr>");
            });
            writer.write("</table>");
            writer.write("</body>");
            writer.write("</html>");
        } catch (UserNotFoundException e) {
            response.setStatus(404);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }
}
