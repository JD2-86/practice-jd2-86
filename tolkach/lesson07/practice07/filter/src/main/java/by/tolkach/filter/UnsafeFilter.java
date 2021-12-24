package by.tolkach.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(urlPatterns = "/unsafe")
public class UnsafeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = "WEB-INF/jsp/unsafe.jsp";
        servletRequest.getRequestDispatcher(path).forward(servletRequest,servletResponse);
    }
}
