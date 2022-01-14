package by.zhigalko.dao_hw.servlet.task3_update;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/update-artist")
public class ServletUpdateArtist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldArtist = request.getParameter("old_artist");
        String newArtistName = request.getParameter("new_artist");
        String newCountry = request.getParameter("new_country");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            Artist foundArtist = artistDao.findByName(oldArtist);
            Artist artist = artistDao.update(foundArtist, newArtistName, newCountry);
            request.setAttribute("artist", artist);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-artist.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
