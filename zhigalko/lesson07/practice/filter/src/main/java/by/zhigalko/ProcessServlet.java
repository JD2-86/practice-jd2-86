package by.zhigalko;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProcessServlet", value = "/process")
public class ProcessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String initUsername = getServletContext().getInitParameter("username");
        String initPassword = getServletContext().getInitParameter("password");
        if (username.equals(initUsername) && password.equals(initPassword)) {
            getServletContext().getRequestDispatcher("/hide_page.jsp").forward(request,response);
        } else {
            getServletContext().getRequestDispatcher("/authentification.jsp").forward(request,response);
        }
    }
}
