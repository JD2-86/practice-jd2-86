package by.zhigalko;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(urlPatterns = "/unsafe")
public class UnsafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
         request.getRequestDispatcher("/safe.jsp").forward(request,response);
    }
}
