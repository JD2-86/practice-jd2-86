package by.shcharbunou.usermanagementwebapplication.servlets.task6;

import by.shcharbunou.usermanagementwebapplication.entities.User;
import by.shcharbunou.usermanagementwebapplication.repositories.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateUserByIDServlet", value = "/api/users/")
public class UpdateUserByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/updateUserByID.jsp");
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
