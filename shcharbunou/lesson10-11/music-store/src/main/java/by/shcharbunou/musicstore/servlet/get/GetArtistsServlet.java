package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GetArtistsServlet", value = "/get-artists")
public class GetArtistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long page = Long.parseLong(request.getParameter("page"));
        long pageSize = Long.parseLong(request.getParameter("pageSize"));
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", page);
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            Map<Long, Artist> artists = artistDao.findAllArtists(page, pageSize);
            int artistsCount = artistDao.countArtist();
            int pagesCount = (int) Math.ceil(artistsCount * (double) 1 / pageSize);
            request.setAttribute("pagesCount", pagesCount);
            request.setAttribute("artists", artists);
            getServletContext().getRequestDispatcher("/jsp-content/get-jsp/get-artists.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request, response);
        }
    }
}
