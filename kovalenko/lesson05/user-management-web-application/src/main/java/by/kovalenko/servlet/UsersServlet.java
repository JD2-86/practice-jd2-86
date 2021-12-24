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
            Integer page = Integer.parseInt(request.getParameter("page"));
            Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if (page < 1 || pageSize < 1) {
                throw new Exception();
            }
            List<User> users = userService.getUsersPartition(page, pageSize);
            if (users.isEmpty()){
                throw new UserNotFoundException();
            }
            writer.write("<table>");
            String contextPath = request.getContextPath();
            users.forEach(user -> {
                writer.write("<tr>");
                writer.write("<td>");
                writer.write("user id: </br> <a href='" + contextPath + "/view/users/" + user.getId() + "'> " + user.getId() + "</a>");
                writer.write("</td>");
                writer.write("user name: " + user.getUserName());
                writer.write("</tr>");
            });
            writer.write("</table>");


        } catch (UserNotFoundException e) {
            response.setStatus(404);
        } catch (Exception e) {
            response.setStatus(400);
        }


    }
}
