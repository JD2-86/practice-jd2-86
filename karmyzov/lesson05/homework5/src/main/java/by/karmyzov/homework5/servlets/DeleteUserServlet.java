package by.karmyzov.homework5.servlets;


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

@WebServlet(name = "DeleteUserServlet", value = "/api/users/delete/")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.nonNull(request.getParameter("id"))) {
            doDelete(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/deleteUserByID.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDelete(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        UserRepository db = UserRepository.getInstance();
        try (PrintWriter writer = resp.getWriter()) {
            if (db.findUserInDB(id)) {
                db.deleteUserFromDB(id);
                resp.sendRedirect(req.getContextPath() + "/view/users");
            } else {
                writer.write("<h1>Error: Something went wrong :/</h1>");
            }
        }
    }
}