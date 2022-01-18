package by.shcharbunou.musicstore.servlet;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.ArtistSongDao;
import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.dao.impl.ArtistSongDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteArtistServlet", value = "/delete-artist")
public class DeleteArtistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        ArtistSongDao artistSongDao = ArtistSongDaoImpl.getInstance();
        try {
            List<Artist> artists = artistDao.findByName(name);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist artist = artists.get(0);
            req.setAttribute("artist", artist);
            artistDao.delete(artist);
            artistSongDao.deleteArtist(artist);
            getServletContext().getRequestDispatcher("/WEB-INF/artist.jsp").forward(req, resp);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    }
}
