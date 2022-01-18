package by.shcharbunou.musicstore.servlet.update;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.ArtistSongDao;
import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.dao.impl.ArtistSongDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateArtistServlet", value = "/update-artist")
public class UpdateArtistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldArtistName = req.getParameter("old_artist");
        String updatedArtistName = req.getParameter("new_artist");
        String updatedCountry = req.getParameter("new_country");
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        try {
            List<Artist> artists = artistDao.findByName(oldArtistName);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist currentArtist = artists.get(0);
            Artist updatedArtist = artistDao.update(currentArtist, updatedArtistName, updatedCountry);
            req.setAttribute("artist", updatedArtist);
            getServletContext().getRequestDispatcher("/jsp-content/artist.jsp").forward(req, resp);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(req, resp);
        }
    }
}
