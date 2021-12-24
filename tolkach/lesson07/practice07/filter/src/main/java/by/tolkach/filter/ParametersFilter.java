package by.tolkach.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = "*")
public class ParametersFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Enumeration<String> names = servletRequest.getParameterNames();

        while (names.hasMoreElements()) {
            String currentName = names.nextElement();
            System.out.println(currentName + ": " + servletRequest.getParameter(currentName));
        }
    }
}
