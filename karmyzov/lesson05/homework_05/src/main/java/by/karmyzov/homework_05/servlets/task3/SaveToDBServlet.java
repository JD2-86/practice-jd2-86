package by.karmyzov.homework_05.servlets.task3;

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

@WebServlet(name = "SaveToDBServlet", value = "/api/users")
public class SaveToDBServlet extends HttpServlet implements GetAccessToDB {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (PrintWriter writer = response.getWriter()) {
            UserStorage db = getAccess();
            if (db == null) {
                writer.write("<h1>Such DB doesn't exist</h1>");
            } else {
                User newUser = new User();
                newUser.setId(db.getCounter().get());
                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                newUser.setEmail(email);
                newUser.setUsername(username);
                newUser.setPassword(password);
                db.putUserIntoDB(newUser);
                getServletContext().setAttribute("db", db);
                getServletContext().getRequestDispatcher("/servletGetDataFromDB").forward(request, response);
            }
        }
    }
}