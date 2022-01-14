package by.zhigalko.dao_hw.servlet.task4_get_one;

import by.zhigalko.dao_hw.dao.DatabaseException;
import by.zhigalko.dao_hw.dao.SongDaoImpl;
import by.zhigalko.dao_hw.entity.Song;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/get-song")
public class ServletReadSong extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        SongDaoImpl songDao = SongDaoImpl.getInstance();
        try {
            Song song = songDao.findByTitle(title);
            request.setAttribute("song",song);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/show-song.jsp").forward(request,response);
        } catch (DatabaseException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
