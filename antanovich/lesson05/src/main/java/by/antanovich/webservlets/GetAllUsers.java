package by.antanovich.webservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "getAllUsers", value = "/view/users")
public class GetAllUsers extends HttpServlet {

    UserDB db = new UserDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");
        String pageSize = req.getParameter("pageSize");
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            Map<Long, User> database = db.getDatabase();
            Set<Long> keySet = database.keySet();
            long pageNumber = Long.parseLong(page);
            long pageSizeNumber = Long.parseLong(pageSize);
            List<Long> listOfId = keySet.stream()
                    .skip((pageNumber - 1) * pageSizeNumber)
                    .limit(pageSizeNumber)
                    .collect(Collectors.toList());
            writer.write("<table style=width:700px; border:5; align:center;>");
            writer.write("<caption style=font-size:24px;>Users</caption>");
            writer.write("<tr>");
            writer.write("<th>Id</th>");
            writer.write("<th>Firstname</th>");
            writer.write("<th>Lastname</th>");
            writer.write("<th>Email</th>");
            writer.write("<th>Username</th>");
            String path = req.getContextPath() + "/view/users/";
            for (Long id : listOfId) {
                writer.write("<tr>");
                writer.write("<td> <a href=\"" + path + "/" + id + "\">" + id + "</a></td>");
                writer.write("<td>" + db.getUserById(id).getFirstName() + "</td>");
                writer.write("<td>" + db.getUserById(id).getLastName() + "</td>");
                writer.write("<td>" + db.getUserById(id).getEmail() + "</td>");
                writer.write("<td>" + db.getUserById(id).getUsername() + "</td>");
                writer.write("</tr>");
            }
            writer.write("</table> <br>");
            }
        }
    }
