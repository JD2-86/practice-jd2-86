package by.zhigalko.servlets.task1;

import by.zhigalko.entity.User;
import by.zhigalko.storage.GetAccessToDB;
import by.zhigalko.storage.UserStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletViewUser", value = "/view/users/")
public class ServletViewUser extends HttpServlet implements GetAccessToDB {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryId = request.getParameter("id");

        try (PrintWriter writer = response.getWriter()) {
            if (queryId == null) {
                writer.write("<h1> Please enter id in query string: for example ?id=5<h/1>");
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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
