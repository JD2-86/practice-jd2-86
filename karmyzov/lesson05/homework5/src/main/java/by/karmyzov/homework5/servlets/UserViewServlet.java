package by.karmyzov.homework5.servlets;

import by.karmyzov.homework5.entities.User;
import by.karmyzov.homework5.repsitories.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserViewServlet", value = "/view/users/")
public class UserViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestID = req.getParameter("id");

        try (PrintWriter writer = resp.getWriter()) {
            if (requestID != null) {
                UserRepository db = UserRepository.getInstance();
                long id = Long.parseLong(requestID);
                if (db.findUserInDB(id)) {
                    User temporaryUser = db.getUserFromDB(id);
                    writer.write("<h1>Public user info:</h1>");
                    writer.write("<p>ID: " + temporaryUser.getId() + "</p>");
                    writer.write("<p>First Name: " + temporaryUser.getFirstName() + "</p>");
                    writer.write("<p>Last Name: " + temporaryUser.getLastName() + "</p>");
                    writer.write("<p>Email: " + temporaryUser.getEmail() + "</p>");
                    writer.write("<p>Username: " + temporaryUser.getUsername() + "</p>");
                } else {
                    writer.write("<h1>Error: Something went wrong :/</h1>");
                }
            } else {
                writer.write("<h1>Error: Something went wrong :/</h1>");
            }
        }
    }
}