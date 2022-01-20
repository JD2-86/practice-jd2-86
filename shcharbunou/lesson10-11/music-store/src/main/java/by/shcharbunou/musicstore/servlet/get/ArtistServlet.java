package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArtistServlet", value = "/artist")
public class ArtistServlet extends HttpServlet {
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
            getServletContext().setAttribute("artist", artist);
            String path = "/artist/songs?page=1&pageSize=5";
            getServletContext().getRequestDispatcher(path).forward(request,response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request,response);
        }
    }
}
