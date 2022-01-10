package by.zhigalko.dao_hw.servlet.task5_get_join;

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

@WebServlet("/get-song-and-artist")
public class ServletReadSongAndArtist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        ArtistSongLinkDaoImpl artistSongLinkDao = ArtistSongLinkDaoImpl.getInstance();
        try {
            Song song = songDao.findByTitle(title);
            Long artistId = artistSongLinkDao.findIdByTitle(song);
            Artist artist = artistDao.findById(artistId);
            String result = artistSongLinkDao.findArtistAndSong(artist, song);
            String[] strings = result.split(" : ");
            for (String string : strings) {
                if (string.equals(artist.getName())) {
                    request.setAttribute("artist", artist);
                }
                if (string.equals(song.getTitle())) {
                    request.setAttribute("song", song);
                }
            }
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-song.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
