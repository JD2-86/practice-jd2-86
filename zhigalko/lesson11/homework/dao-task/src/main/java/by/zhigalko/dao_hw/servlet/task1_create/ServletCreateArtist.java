package by.zhigalko.dao_hw.servlet.task1_create;

import by.zhigalko.dao_hw.dao.ArtistDao;
import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/new-artist")
public class ServletCreateArtist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artist_name = request.getParameter("artist");
        String country = request.getParameter("country");
        Artist artist = new Artist(artist_name,country);
        request.setAttribute("artist",artist);
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        try {
            artistDao.save(artist);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-artist.jsp").forward(request,response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
