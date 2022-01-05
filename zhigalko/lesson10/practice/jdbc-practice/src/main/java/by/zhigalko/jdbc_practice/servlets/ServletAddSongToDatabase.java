package by.zhigalko.jdbc_practice.servlets;

import by.zhigalko.jdbc_practice.dao.ConnectionToDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ServletAddSongToDatabase", value = "/add-song")
public class ServletAddSongToDatabase extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(Connection connection = ConnectionToDatabase.getConnection()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement(
                    "INSERT INTO jdbc.song(title, album, recorded, length) VALUES (?, ?, ?, ?)");
            String artist = request.getParameter("artist");
            String title = request.getParameter("title");
            String album = request.getParameter("album");
            int recorded = Integer.parseInt(request.getParameter("recorded"));
            String length = request.getParameter("length");
            preparedStatement1.setString(1, title);
            preparedStatement1.setString(2, album);
            preparedStatement1.setInt(3, recorded);
            preparedStatement1.setString(4,length);
            preparedStatement1.executeUpdate();
            request.setAttribute("artist",artist);
            request.setAttribute("title", title);
            request.setAttribute("album",album);
            request.setAttribute("recorded", recorded);
            request.setAttribute("length", length);

            getServletContext().getRequestDispatcher("/WEB-INF/view/result-add-song.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
