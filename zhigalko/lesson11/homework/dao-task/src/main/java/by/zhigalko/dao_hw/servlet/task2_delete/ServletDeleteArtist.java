package by.zhigalko.dao_hw.servlet.task2_delete;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.ArtistSongLinkDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete-artist")
public class ServletDeleteArtist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artist_name = request.getParameter("artist");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        ArtistSongLinkDaoImpl artistSongLinkDao = ArtistSongLinkDaoImpl.getInstance();
        try {
            Artist artist = artistDao.findByName(artist_name);
            request.setAttribute("artist",artist);
            artistDao.delete(artist);
            artistSongLinkDao.deleteArtist(artist);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/deleted-artist.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
