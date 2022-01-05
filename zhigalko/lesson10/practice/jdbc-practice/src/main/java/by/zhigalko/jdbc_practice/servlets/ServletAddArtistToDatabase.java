package by.zhigalko.jdbc_practice.servlets;

import by.zhigalko.jdbc_practice.dao.ConnectionToDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/add-artist")
public class ServletAddArtistToDatabase extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement preparedStatement = null;
        try(Connection connection = ConnectionToDatabase.getConnection()) {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO jdbc.artist(name, country) VALUES (?, ?)");
            String artist = request.getParameter("artist");
            String country = request.getParameter("country");
            preparedStatement.setString(1,artist);
            preparedStatement.setString(2,country);
            preparedStatement.executeUpdate();
            request.setAttribute("artist",artist);
            request.setAttribute("country",country);
            getServletContext().getRequestDispatcher("/WEB-INF/view/result-add-artist.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
