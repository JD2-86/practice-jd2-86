package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.impl.SongDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ArtistSongsServlet", value = "/artist/songs")
public class ArtistSongsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long page = Long.parseLong(request.getParameter("page"));
        long pageSize = Long.parseLong(request.getParameter("pageSize"));
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", page);
        Artist artist = (Artist) getServletContext().getAttribute("artist");
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        try {
            Map<Long, Song> songs = songDao.findAllSongsByArtist(artist, page, pageSize);
            int songsCount = songDao.countSongsByArtist(artist);
            int pagesCount = (int) Math.ceil(songsCount * (double) 1 / pageSize);
            request.setAttribute("pagesCount", pagesCount);
            request.setAttribute("songs", songs);
            getServletContext().getRequestDispatcher("/jsp-content/artist-songs.jsp").forward(request,response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request,response);
        }
    }
}
