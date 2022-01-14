package by.zhigalko.dao_hw.servlet.task1_create;

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

@WebServlet("/new-song")
public class ServletCreateSong extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artist_name = request.getParameter("artist");
        String title = request.getParameter("title");
        String album = request.getParameter("album");
        int recorded = Integer.parseInt(request.getParameter("recorded"));
        String length = request.getParameter("length");
        Song song = new Song(title,album,recorded,length);
        request.setAttribute("song",song);
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        ArtistSongLinkDaoImpl artistSongLinkDao = ArtistSongLinkDaoImpl.getInstance();
        try {
            songDao.save(song);
            Artist artist = artistDao.findByName(artist_name);
            artistSongLinkDao.save(artist,song);
            request.setAttribute("artist",artist);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-song.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
