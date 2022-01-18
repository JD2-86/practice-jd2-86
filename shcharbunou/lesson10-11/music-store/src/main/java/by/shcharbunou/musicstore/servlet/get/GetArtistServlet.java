package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetArtistServlet", value = "/get-artist")
public class GetArtistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        try {
            List<Artist> artists = artistDao.findByName(name);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist artist = artists.get(0);
            request.setAttribute("artist", artist);
            getServletContext().getRequestDispatcher("/jsp-content/artist.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request, response);
        }
    }
}
