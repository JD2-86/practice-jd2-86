package by.shcharbunou.musicstore.servlet;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddArtistServlet", value = "/add-artist")
public class AddArtistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Artist artist = new Artist();
        artist.setName(name);
        artist.setCountry(country);
        request.setAttribute("artist", artist);
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        try {
            artistDao.save(artist);
            getServletContext().getRequestDispatcher("/WEB-INF/artist.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}
