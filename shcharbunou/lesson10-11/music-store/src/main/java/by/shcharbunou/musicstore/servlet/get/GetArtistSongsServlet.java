package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetArtistSongsServlet", value = "/get-artist-songs")
public class GetArtistSongsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistName = request.getParameter("name");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            List<Artist> artists = artistDao.findByName(artistName);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist artist = artists.get(0);
            Map<Long, Song> songs = artistDao.findAllSongs(artist);
            request.setAttribute("songs", songs);
            request.setAttribute("artist", artist);
            getServletContext().getRequestDispatcher("/jsp-content/get-jsp/get-songs.jsp").forward(request,response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request,response);
        }
    }
}
