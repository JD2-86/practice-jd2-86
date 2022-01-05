package by.karmyzov.homework05;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class shows user information.
 */

@WebServlet(urlPatterns = "/users/*")
public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Viewer viewer = new Viewer();
        UsersFinderWriter usersFinderWriter = new UsersFinderWriter();

        resp.setContentType("text/html");

        String id = req.getPathInfo().replaceFirst("/","");
        String[] userData = usersFinderWriter.findUser(id, req);
        try (PrintWriter writer = resp.getWriter()) {
            writer.println(viewer.getText(userData));
        }
    }
}