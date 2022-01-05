package by.karmyzov.practice05.task7;

import by.karmyzov.practice05.task7.entity.EntityStorage;
import by.karmyzov.practice05.task7.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletGetDataFromForm", value = "/servletGetDataFromForm")
public class ServletGetDataFromForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        ServletContext servletContext = getServletContext();
        try (PrintWriter writer = response.getWriter()) {
            String databaseName = getServletContext().getInitParameter("database");
            if (databaseName.equals(EntityStorage.class.getName())) {
                EntityStorage db = new EntityStorage();
                User newUser = new User();
                newUser.setName(name);
                newUser.setSurname(surname);
                newUser.setEmail(email);
                db.putUserToDB(newUser);
                servletContext.setAttribute("db", db);
                servletContext.getRequestDispatcher("/servletGetDataFromDB").forward(request, response);
            } else {
                writer.write("<h1>Such DB doesn't exist</h1>");
            }
        }
    }
}