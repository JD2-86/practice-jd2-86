package by.zhigalko.jdbc_practice.servlets;

import by.zhigalko.jdbc_practice.dao.ConnectionToDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteSong", value = "/delete-song")
public class ServletDeleteSong extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String del_song = request.getParameter("del-song");
        try(Connection connection = ConnectionToDatabase.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM jdbc.song WHERE title LIKE '" + del_song +"'");
            preparedStatement.executeUpdate();
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
