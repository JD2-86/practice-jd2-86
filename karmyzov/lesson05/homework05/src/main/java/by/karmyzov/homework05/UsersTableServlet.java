package by.karmyzov.homework05;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class shows all users in table.
 */

@WebServlet(urlPatterns = "/users")
public class UsersTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Viewer viewer = new Viewer();

        resp.setContentType("text/html");
        String[] userData;
        String page = req.getParameter("page");
        String pageSize = req.getParameter("pageSize");
        String line = "";
        Integer lineNumber = 0;

        String fileName = new WorkerWithFile().getListOfUsers(req);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName));
             PrintWriter writer = resp.getWriter()) {
            writer.println(viewer.getPageSelect(page));
            writer.println(viewer.getPageSizeSelect(page));
            writer.println(viewer.getTableHeader());

            if (page == null && pageSize == null) {
                while ((line = br.readLine()) != null) {
                    userData = line.split(";");
                    writer.println(viewer.getTableBody(userData));
                }
            } else if (page != null) {
                lineNumber = Integer.parseInt(page);
                for (Integer i = 1; i < lineNumber; i++) {
                    br.readLine();
                }
                line = br.readLine();
                if (line != null) {
                    userData = line.split(";");
                    writer.println(viewer.getTableBody(userData));
                }
            } else if (pageSize != null) {
                lineNumber = Integer.parseInt(pageSize);
                for (Integer i = 0; i < lineNumber; i++) {
                    line = br.readLine();
                    if (line != null) {
                        userData = line.split(";");
                        writer.println(viewer.getTableBody(userData));
                    }
                }
            }
            writer.println(viewer.getTableFooter());
        }
    }
}