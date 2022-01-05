package by.karmyzov.homework_05.servlets.task3;

import by.karmyzov.homework_05.entity.User;
import by.karmyzov.homework_05.storage.UserStorage;
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
            UserStorage db = (UserStorage) getServletContext().getAttribute("db");

            long id = 0L;
            if(request.getParameter("id")==null){
                id = db.getCounter().get();
            } else {
                id= Long.parseLong(request.getParameter("id"));
            }
            if(db.findUserInDB(id)){
                User user = db.getUserFromDB(id);
                writer.write("<h1> User data from DB: </h1>" );
                writer.write("<p>Id: " + id + "</p>");
                writer.write("<p>Name: " + user.getFirstName() + "</p>");
                writer.write("<p>Lastname: " + user.getLastName() + "</p>");
                writer.write("<p>Email: " + user.getEmail() + "</p>");
                writer.write("<p>Username: " + user.getUsername() + "</p>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}