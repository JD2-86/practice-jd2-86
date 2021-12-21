package by.rolkach.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * Class shows all users in table.
 */

@WebServlet(urlPatterns = "/users")
public class UsersTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Viewer viewer = new Viewer();

        resp.setContentType("text/html");

        String fileName = new WorkerWithFile().getListOfUsers(req);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName));
             PrintWriter writer = resp.getWriter()) {
            String line;
            writer.println(viewer.getTableHeader());
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(";");
                writer.println(viewer.getTableBody(userData));
            }
            writer.println(viewer.getTableFooter());
        }
    }
}
