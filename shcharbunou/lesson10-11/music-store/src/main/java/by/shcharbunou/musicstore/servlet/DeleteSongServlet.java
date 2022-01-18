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

@WebServlet(name = "DeleteSongServlet", value = "/delete-song")
public class DeleteSongServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistName = req.getParameter("artist");
        String songTitle = req.getParameter("song");
        ArtistSongDao artistSongDao = ArtistSongDaoImpl.getInstance();
        ArtistDao artistDao = ArtistDaoImpl.getInstance();
        SongDao songDao = SongDaoImpl.getInstance();
        try {
            List<Song> songs = songDao.findByTitle(songTitle);
            if (songs.size() != 1) {
                throw new DatabaseException();
            }
            Song song = songs.get(0);
            List<Artist> artists = artistDao.findByName(artistName);
            if (artists.size() != 1) {
                throw new DatabaseException();
            }
            Artist artist = artists.get(0);
            req.setAttribute("artist", artist);
            req.setAttribute("song", song);
            songDao.delete(song);
            artistSongDao.deleteSong(song);
            getServletContext().getRequestDispatcher("/jsp-content/song.jsp").forward(req, resp);
        } catch (DatabaseException e) {
            getServletContext().getRequestDispatcher("/jsp-content/error.jsp").forward(req, resp);
        }
    }
}
