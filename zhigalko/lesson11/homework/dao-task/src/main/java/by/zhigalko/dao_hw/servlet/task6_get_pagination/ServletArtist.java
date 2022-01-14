package by.zhigalko.dao_hw.servlet.task6_get_pagination;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/artist")
public class ServletArtist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistName = request.getParameter("artist");
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            Artist artist = artistDao.findByName(artistName);
            getServletContext().setAttribute("artist", artist);
            String path = "/artist/songs?page=1&pageSize=3";
            getServletContext().getRequestDispatcher(path).forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
