package by.zhigalko.dao_hw.servlet.task4_get_one;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/get-artist")
public class ServletReadArtist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistName = request.getParameter("artist");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            Artist artist = artistDao.findByName(artistName);
            request.setAttribute("artist",artist);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-artist.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
