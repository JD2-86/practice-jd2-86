package by.shcharbunou.musicstore.servlet.get;

import by.shcharbunou.musicstore.dao.ArtistDao;
import by.shcharbunou.musicstore.dao.ArtistSongDao;
import by.shcharbunou.musicstore.dao.SongDao;
import by.shcharbunou.musicstore.dao.impl.ArtistDaoImpl;
import by.shcharbunou.musicstore.dao.impl.ArtistSongDaoImpl;
import by.shcharbunou.musicstore.dao.impl.SongDaoImpl;
import by.shcharbunou.musicstore.entity.Artist;
import by.shcharbunou.musicstore.entity.Song;
import by.shcharbunou.musicstore.exception.DatabaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetSongAndArtistServlet", value = "/get-song-and-artist")
public class GetSongAndArtistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        SongDao songDao = SongDaoImpl.getInstance();
        ArtistSongDao artistSongDao = ArtistSongDaoImpl.getInstance();
        try {
            List<Song> songs = songDao.findByTitle(title);
            if (songs.size() != 1) {
                throw new DatabaseException();
            }
            Song song = songs.get(0);
            Long artistId = artistSongDao.findIdByTitle(song);
            Artist artist = artistDao.findById(artistId);
            request.setAttribute("artist", artist);
            request.setAttribute("song", song);
            getServletContext().getRequestDispatcher("/jsp-content/song.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(request, response);
        }
    }
}
