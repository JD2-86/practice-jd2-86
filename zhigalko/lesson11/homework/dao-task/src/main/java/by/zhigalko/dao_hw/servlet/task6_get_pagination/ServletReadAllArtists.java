package by.zhigalko.dao_hw.servlet.task6_get_pagination;

import by.zhigalko.dao_hw.dao.ArtistDaoImpl;
import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.entity.Artist;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/get-all-artists")
public class ServletReadAllArtists extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long page = Long.parseLong(request.getParameter("page"));
        long pageSize = Long.parseLong(request.getParameter("pageSize"));
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", page);
        ArtistDaoImpl artistDao = ArtistDaoImpl.getInstance();
        try {
            Map<Long, Artist> allArtists = artistDao.findAllArtists(page,pageSize);
            int artistNumber = artistDao.countArtist();
            int pagesNumber = (int) Math.ceil(artistNumber * 1.0 / pageSize);
            request.setAttribute("pagesNumber", pagesNumber);
            request.setAttribute("allArtists", allArtists);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-all-artists.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
