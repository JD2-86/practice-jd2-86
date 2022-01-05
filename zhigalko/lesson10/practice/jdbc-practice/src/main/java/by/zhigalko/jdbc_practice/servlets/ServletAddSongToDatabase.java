package by.zhigalko.jdbc_practice.servlets;

import by.zhigalko.jdbc_practice.dao.ConnectionToDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

@WebServlet(name = "ServletAddSongToDatabase", value = "/add-song")
public class ServletAddSongToDatabase extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(Connection connection = ConnectionToDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO jdbc.song(title, album, recorded, length) VALUES (?, ?, ?, ?)");
            String title = request.getParameter("title");
            String album = request.getParameter("album");
            int recorded = Integer.parseInt(request.getParameter("recorded"));
            Time length = Time.valueOf(request.getParameter("length"));
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, album);
            preparedStatement.setInt(3, recorded);
            preparedStatement.setTime(4,length);
            connection.prepareStatement("INSERT INTO jdbc.artist_song_link(artist_id, song_id) VALUES (?,?)");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,10);
            preparedStatement.executeUpdate();
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
