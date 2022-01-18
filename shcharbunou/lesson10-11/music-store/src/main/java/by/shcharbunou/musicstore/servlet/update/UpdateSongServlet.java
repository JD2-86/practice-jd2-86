package by.shcharbunou.musicstore.servlet.update;

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

@WebServlet(name = "UpdateSongServlet", value = "/UpdateSongServlet")
public class UpdateSongServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistName = req.getParameter("artist");
        String oldTitle = req.getParameter("old_title");
        String title = req.getParameter("new_title");
        String album = req.getParameter("new_album");
        int recorded = Integer.parseInt(req.getParameter("new_recorded"));
        String length = req.getParameter("new_length");
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        ArtistSongDao artistSongDao = ArtistSongDaoImpl.getInstance();
        SongDao songDao = SongDaoImpl.getInstance();
        try {
            List<Song> songs = songDao.findByTitle(oldTitle);
            if (songs.size() != 1) {
                throw new DatabaseException();
            }
            Song currentSong = songs.get(0);
            Song updatedSong = songDao.update(currentSong, title, album, recorded, length);
            req.setAttribute("song", updatedSong);
            List<Artist> artists = artistDao.findByName(artistName);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist artist = artists.get(0);
            artistSongDao.update(artist, updatedSong);
            req.setAttribute("artist", artist);
            getServletContext().getRequestDispatcher("/jsp-content/song.jsp").forward(req, resp);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(req, resp);
        }
    }
}
