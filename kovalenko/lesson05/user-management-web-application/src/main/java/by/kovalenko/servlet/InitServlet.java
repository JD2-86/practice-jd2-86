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
        PrintWriter writer = response.getWriter();
        writer.write("<html><body>");
        writer.write("<h1> Repo initialized </h1>");
        writer.write("<h2> Number of initialized users: " + userSize + "</h2>");
        writer.write("</body></html>");
    }
}
