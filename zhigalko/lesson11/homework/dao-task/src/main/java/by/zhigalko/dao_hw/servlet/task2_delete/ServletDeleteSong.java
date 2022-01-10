package by.zhigalko.dao_hw.servlet.task2_delete;

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

@WebServlet("/delete-song")
public class ServletDeleteSong extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artist_name = request.getParameter("artist");
        String song_title = request.getParameter("song");
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        ArtistSongLinkDaoImpl artistSongLinkDao = ArtistSongLinkDaoImpl.getInstance();
        try {
            Artist artist = artistDao.findByName(artist_name);
            Song song = songDao.findByTitle(song_title);
            request.setAttribute("artist",artist);
            request.setAttribute("song",song);
            artistSongLinkDao.deleteSong(song);
            songDao.delete(song);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/deleted-song.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
