package by.shcharbunou.musicstore.servlet;

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

@WebServlet(name = "AddSongServlet", value = "/add-song")
public class AddSongServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistName = request.getParameter("artist");
        String title = request.getParameter("title");
        String album = request.getParameter("album");
        int recorded = Integer.parseInt(request.getParameter("recorded"));
        String length = request.getParameter("length");
        Song song = new Song();
        song.setTitle(title);
        song.setAlbum(album);
        song.setRecorded(recorded);
        song.setLength(length);
        request.setAttribute("song", song);
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        SongDao songDao = SongDaoImpl.getInstance();
        ArtistSongDao artistSongDao = ArtistSongDaoImpl.getInstance();
        try {
            songDao.save(song);
            List<Artist> artists = artistDao.findByName(artistName);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist artist = artists.get(0);
            request.setAttribute("artist", artist);
            artistSongDao.save(artist, song);
            getServletContext().getRequestDispatcher("/WEB-INF/song.jsp").forward(request, response);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}
