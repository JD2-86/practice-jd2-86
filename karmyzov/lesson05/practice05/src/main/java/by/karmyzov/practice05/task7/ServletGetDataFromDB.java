package by.karmyzov.practice05.task7;

import by.karmyzov.practice05.task7.entity.EntityStorage;
import by.karmyzov.practice05.task7.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletGetDataFromDB", value = "/servletGetDataFromDB")
public class ServletGetDataFromDB extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter writer = response.getWriter()) {
            EntityStorage database = (EntityStorage) getServletContext().getAttribute("db");
            if (database.findUserInDB(1)) {
                User user = database.getUserFromDB(1);
                writer.write("<h1> User data from DB: </h1>");
                writer.write("<p>Name: " + user.getName() + "</p>");
                writer.write("<p>Surname: " + user.getSurname() + "</p>");
                writer.write("<p>Email: " + user.getEmail() + "</p>");
            }
        }
    }
}