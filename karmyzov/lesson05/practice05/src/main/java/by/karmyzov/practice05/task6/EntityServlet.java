package by.karmyzov.practice05.task6;


import by.karmyzov.practice05.task6.entity.EntityStorage;
import by.karmyzov.practice05.task6.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EntityServlet", value = "/entity-servlet")
public class EntityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        String surname;
        String email;

        String queryId = request.getParameter("id");
        try (PrintWriter writer = response.getWriter()) {
            if(queryId==null){
                writer.write("<h1> Please enter id in query string</h1>");
            } else {
                String databaseName = getServletConfig().getInitParameter("database");
                if(databaseName.equals(EntityStorage.class.getName())){
                    EntityStorage db = new EntityStorage();
                    if(db.findUserInDB(Integer.parseInt(queryId))){
                        User userFromDB = db.getUserFromDB(Integer.parseInt(queryId));
                        name  = userFromDB.getName();
                        surname = userFromDB.getSurname();
                        email = userFromDB.getEmail();
                        writer.write("<h1>Entity data:</h1>");
                        writer.write("<p> Name: " + name + "</p>");
                        writer.write("<p> Surname: " + surname + "</p>");
                        writer.write("<p> E-mail: " + email + "</p>");
                    } else {
                        writer.write("<h1>DB can't find such entity</h1>");
                    }
                } else {
                    writer.write("<h1>Such DB doesn't exist</h1>");
                }
            }
        }
    }
}