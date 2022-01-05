package by.karmyzov.homework_05.servlets.task4;
import by.karmyzov.homework_05.entity.User;
import by.karmyzov.homework_05.storage.GetAccessToDB;
import by.karmyzov.homework_05.storage.UserStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "ShowUsersServlet", value = "/view/users")
public class ShowUsersServlet extends HttpServlet implements GetAccessToDB {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        try (PrintWriter writer = response.getWriter()) {
            UserStorage db = getAccess();
            if (db == null) {
                writer.write("<h1>Such DB doesn't exist</h1>");
            } else {
                Map<Long, User> database = db.getDatabase();
                Set<Long> keySet = database.keySet();
                long pageNumber = Long.parseLong(page);
                long pageSizeNumber = Long.parseLong(pageSize);
                List<Long> listOfId = keySet.stream()
                        .skip((pageNumber - 1) * pageSizeNumber)
                        .limit(pageSizeNumber)
                        .collect(Collectors.toList());
                request.setAttribute("listOfId", listOfId);
                getServletContext().getRequestDispatcher("/read-servlet").forward(request, response);
            }
        }
    }
}