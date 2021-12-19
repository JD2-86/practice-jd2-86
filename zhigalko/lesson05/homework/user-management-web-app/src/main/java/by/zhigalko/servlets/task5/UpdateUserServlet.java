package by.zhigalko.servlets.task5;

import by.zhigalko.entity.User;
import by.zhigalko.storage.GetAccessToDB;
import by.zhigalko.storage.UserStorage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateUserServlet", value = "/view/command/update-user")
public class UpdateUserServlet extends HttpServlet implements GetAccessToDB {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String newFirstName = request.getParameter("firstName");
        String newLastName = request.getParameter("lastName");
        String newEmail = request.getParameter("email");
        String newUsername = request.getParameter("username");
        String newPassword = request.getParameter("password");
        try (PrintWriter writer = response.getWriter()) {
            UserStorage db = getAccess();
            if (db == null) {
                writer.write("<h1>Such DB doesn't exist</h1>");
            } else {
                if(db.findUserInDB(id)){
                    User userFromDB = db.getUserFromDB(id);
                    userFromDB.setFirstName(newFirstName);
                    userFromDB.setLastName(newLastName);
                    userFromDB.setEmail(newEmail);
                    userFromDB.setUsername(newUsername);
                    userFromDB.setPassword(newPassword);
                    db.putUserIntoDB(id,userFromDB);
                    getServletContext().setAttribute("db", db);
                    response.sendRedirect("/view/users/");
                } else {
                    writer.write("<h1>DB can't find this user</h1>");
                }
            }
        }
    }
}
