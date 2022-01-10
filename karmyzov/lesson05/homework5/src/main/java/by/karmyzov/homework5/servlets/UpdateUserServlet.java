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

@WebServlet(name = "UpdateUserServlet", value = "/view/command/update-user")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String updatedFirstName = request.getParameter("firstname");
        String updatedLastName = request.getParameter("lastname");
        String updatedEmail = request.getParameter("email");
        String updatedUsername = request.getParameter("username");
        String updatedPassword = request.getParameter("password");

        try (PrintWriter writer = response.getWriter()) {
            UserRepository db = UserRepository.getInstance();
            if (db.findUserInDB(id)) {
                User temporaryUser = db.getUserFromDB(id);
                temporaryUser.setFirstName(updatedFirstName);
                temporaryUser.setLastName(updatedLastName);
                temporaryUser.setEmail(updatedEmail);
                temporaryUser.setUsername(updatedUsername);
                temporaryUser.setPassword(updatedPassword);
                db.putUserIntoDB(id, temporaryUser);
                response.sendRedirect(request.getContextPath() + "/view/users/?id=" + id);
            } else {
                writer.write("<h1>Error: Something went wrong :/</h1>");
            }
        }
    }
}