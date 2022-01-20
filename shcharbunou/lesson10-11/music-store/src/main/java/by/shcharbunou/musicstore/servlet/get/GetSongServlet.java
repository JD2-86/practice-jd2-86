package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.SongDao;
import by.shcharbunou.musicstore.dao.impl.SongDaoImpl;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetSongServlet", value = "/get-song")
public class GetSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        SongDao songDao = SongDaoImpl.getInstance();
        try {
            List<Song> songs = songDao.findByTitle(title);
            if (songs.size() != 1) {
                throw new DatabaseException();
            }
            Song song = songs.get(0);
            request.setAttribute("song", song);
            getServletContext().getRequestDispatcher("/jsp-content/song.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request, response);
        }
    }
}
