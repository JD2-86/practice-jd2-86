package by.zhigalko;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UnsafeServlet", value = "/unsafe")
public class UnsafeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter writer = response.getWriter()){
            writer.write("<h1>UNSAFE Servlet</h1>");
        }
    }
}
