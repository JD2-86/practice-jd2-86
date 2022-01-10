package by.karmyzov.homework5.servlets;

import by.karmyzov.homework5.entities.User;
import by.karmyzov.homework5.repsitories.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "UpdateUserByIDServlet", value = "/api/users/")
public class UpdateUserByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        if (Objects.nonNull(req.getParameter("id"))) {
            requestDispatcher = req.getRequestDispatcher("/updateUserByID.jsp");
        } else {
            requestDispatcher = req.getRequestDispatcher("/updateUserFullForm.jsp");
        }
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String updatedFirstName = req.getParameter("firstname");
        String updatedLastName = req.getParameter("lastname");
        String updatedEmail = req.getParameter("email");
        String updatedUsername = req.getParameter("username");
        String updatedPassword = req.getParameter("password");

        try (PrintWriter writer = resp.getWriter()) {
            UserRepository db = UserRepository.getInstance();
            if (db.findUserInDB(id)) {
                User temporaryUser = db.getUserFromDB(id);
                temporaryUser.setFirstName(updatedFirstName);
                temporaryUser.setLastName(updatedLastName);
                temporaryUser.setEmail(updatedEmail);
                temporaryUser.setUsername(updatedUsername);
                temporaryUser.setPassword(updatedPassword);
                db.putUserIntoDB(id, temporaryUser);
                resp.sendRedirect(req.getContextPath() + "/view/users/?id=" + id);
            } else {
                writer.write("<h1>Error: Something went wrong :/</h1>");
            }
        }
    }
}