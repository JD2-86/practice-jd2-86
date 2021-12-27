package by.shcharbunou.usermanagementwebapplication.servlets.task4;

import by.shcharbunou.usermanagementwebapplication.entities.User;
import by.shcharbunou.usermanagementwebapplication.repositories.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "UsersTableServlet", value = "/view/users")
public class UsersTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long page = Long.parseLong(request.getParameter("page"));
        long pageSize = Long.parseLong(request.getParameter("pageSize"));
        UserRepository db = UserRepository.getInstance();
        Map<Long, User> temporaryDB = db.getDatabase();
        Set<Long> setID = temporaryDB.keySet();
        List<Long> listID = setID.stream()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<table border=\"1\"> <br>");
            writer.write("<caption>Users Table</caption>");
            writer.write("<tr>");
            writer.write("<th>ID</th>");
            writer.write("<th>First Name</th>");
            writer.write("<th>Last Name</th>");
            writer.write("<th>Email</th>");
            writer.write("<th>Username</th>");
            String path = request.getContextPath() + "/view/users/?id=";
            for (Long id : listID) {
                writer.write("<tr>");
                writer.write("<td> <a href=\"" + path + id + "\">" + id + "</a></td>");
                writer.write("<td>" + db.getUserFromDB(id).getFirstName() + "</td>");
                writer.write("<td>" + db.getUserFromDB(id).getLastName() + "</td>");
                writer.write("<td>" + db.getUserFromDB(id).getEmail() + "</td>");
                writer.write("<td>" + db.getUserFromDB(id).getUsername() + "</td>");
                writer.write("</tr>");
            }
            writer.write("</table> <br>");
        }
    }
}
