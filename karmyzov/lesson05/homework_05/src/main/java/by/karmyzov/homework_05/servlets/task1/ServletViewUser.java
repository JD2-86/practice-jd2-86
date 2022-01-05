package by.karmyzov.homework_05.servlets.task1;

import by.karmyzov.homework_05.entity.User;
import by.karmyzov.homework_05.storage.GetAccessToDB;
import by.karmyzov.homework_05.storage.UserStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletViewUser", value = "/view/users/*")
public class ServletViewUser extends HttpServlet implements GetAccessToDB {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter writer = response.getWriter()) {
            String[] split = request.getRequestURI().split("[^0-9]*");
            StringBuilder builder = new StringBuilder();
            for (String s : split) {
                builder.append(s);
            }
            String queryId = builder.toString();
            if (queryId.isEmpty()) {
                writer.write("<h1> Please add id in query string: for example /10");
            } else {
                UserStorage db = getAccess();
                if (db == null) {
                    writer.write("<h1>Such DB doesn't exist</h1>");
                } else {
                    long id = Long.parseLong(queryId);
                    if (db.findUserInDB(id)) {
                        User userFromDB = db.getUserFromDB(id);
                        writer.write("<h1>Entity data:</h1>");
                        writer.write("<p> Id: " + id + "</p>");
                        writer.write("<p> Name: " + userFromDB.getFirstName() + "</p>");
                        writer.write("<p> Lastname: " + userFromDB.getLastName() + "</p>");
                        writer.write("<p> E-mail: " + userFromDB.getEmail() + "</p>");
                        writer.write("<p> Username: " + userFromDB.getUsername() + "</p>");
                    } else {
                        writer.write("<h1>DB can't find such entity</h1>");
                    }
                }
            }
        }
    }
}