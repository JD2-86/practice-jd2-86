package by.zhigalko.dao_hw.servlet.task6_get_pagination;

import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.dao.SongDaoImpl;
import by.zhigalko.dao_hw.entity.Song;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/get-all-songs")
public class ServletReadAllSongs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long page = Long.parseLong(request.getParameter("page"));
        long pageSize = Long.parseLong(request.getParameter("pageSize"));
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", page);
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        try {
            Map<Long, Song> allSongs = songDao.findAllSongs(page,pageSize);
            int songNumber = songDao.countSongs();
            int pagesNumber = (int) Math.ceil(songNumber * 1.0 / pageSize);
            request.setAttribute("pagesNumber", pagesNumber);
            request.setAttribute("allSongs", allSongs);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-all-songs.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
