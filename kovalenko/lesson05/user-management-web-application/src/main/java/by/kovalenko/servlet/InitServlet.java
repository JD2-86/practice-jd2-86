package by.kovalenko.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import by.kovalenko.service.UserInitializer;
import by.kovalenko.service.impl.UserInitializerImpl;

@WebServlet(urlPatterns = "/admin/init")
public class InitServlet extends HttpServlet {
    private final UserInitializer userInitializer = UserInitializerImpl.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Repo initialized");
        int userSize = userInitializer.init();
        response.setContentType("text/html");

        // Init
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Repo initialized </h1>");
        out.println("<h2> Number of initialized users: " +userSize + "</h2>");
        out.println("</body></html>");
    }
}