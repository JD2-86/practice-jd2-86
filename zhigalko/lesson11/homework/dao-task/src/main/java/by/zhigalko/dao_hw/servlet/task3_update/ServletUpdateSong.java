package by.zhigalko.dao_hw.servlet.task3_update;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.ArtistSongLinkDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.dao.SongDaoImpl;
import by.zhigalko.dao_hw.entity.Artist;
import by.zhigalko.dao_hw.entity.Song;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/update-song")
public class ServletUpdateSong extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artist_name = request.getParameter("artist");
        String oldTitle = request.getParameter("old_title");
        String newTitle = request.getParameter("new_title");
        String album = request.getParameter("new_album");
        int recorded = Integer.parseInt(request.getParameter("new_recorded"));
        String length = request.getParameter("new_length");
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        ArtistSongLinkDaoImpl artistSongLinkDao = ArtistSongLinkDaoImpl.getInstance();
        try {
            Song foundSong = songDao.findByTitle(oldTitle);
            Song song = songDao.update(foundSong, newTitle, album, recorded, length);
            Artist artist = artistDao.findByName(artist_name);
            artistSongLinkDao.update(artist,song);
            request.setAttribute("artist", artist);
            request.setAttribute("song", song);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-song.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
