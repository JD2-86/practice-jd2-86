package by.zhigalko.servlets.task4;

import by.zhigalko.storage.GetAccessToDB;
import by.zhigalko.storage.UserStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ReadFromServlet", value = "/read-servlet")
public class ReadFromServlet extends HttpServlet implements GetAccessToDB {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Long> listOfId = (List<Long>) request.getAttribute("listOfId");
        try (PrintWriter writer = response.getWriter()) {
            if (listOfId == null) {
                writer.write("<h1>Such users don't find</h1>");
            } else {
                UserStorage db = getAccess();
                if (db == null) {
                    writer.write("<h1>Such DB doesn't exist</h1>");
                } else {
                    writer.write("<table border=\"1\"> <br>");
                    writer.write("<caption>User's data list</caption>");
                    writer.write("<tr>");
                    writer.write("<th>Id</th>");
                    writer.write("<th>Firstname</th>");
                    writer.write("<th>Lastname</th>");
                    writer.write("<th>Email</th>");
                    writer.write("<th>Username</th>");
                    for (Long id : listOfId) {
                        writer.write("<tr>");
                        writer.write("<td> <a href=\"../view/users/?id=" + id + "\">" + id + "</a></td>");
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
    }
}
