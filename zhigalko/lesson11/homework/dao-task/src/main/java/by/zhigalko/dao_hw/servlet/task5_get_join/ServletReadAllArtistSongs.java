package by.zhigalko.dao_hw.servlet.task5_get_join;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/get-all-artist-songs")
public class ServletReadAllArtistSongs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistName = request.getParameter("artist");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            Artist artist = artistDao.findByName(artistName);
            Map<Long, Song> allSongs = artistDao.findAllSongs(artist);
            request.setAttribute("allSongs", allSongs);
            request.setAttribute("artist", artist);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-all-artist-songs.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
