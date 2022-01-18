package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.impl.SongDaoImpl;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GetSongsServlet", value = "/get-songs")
public class GetSongsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long page = Long.parseLong(request.getParameter("page"));
        long pageSize = Long.parseLong(request.getParameter("pageSize"));
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", page);
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        try {
            Map<Long, Song> songs = songDao.findAllSongs(page, pageSize);
            int songsCount = songDao.countSongs();
            int pagesCount = (int) Math.ceil(songsCount * (double) 1 / pageSize);
            request.setAttribute("songs", songs);
            request.setAttribute("pagesCount", pagesCount);
            getServletContext().getRequestDispatcher("/jsp-content/get-jsp/get-songs.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request, response);
        }
    }
}
