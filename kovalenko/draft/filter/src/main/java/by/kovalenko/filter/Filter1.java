package by.kovalenko.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebFilter(filterName = "helloServlet", value = "/hello-servlet/filter1")
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Set<Map.Entry<String, String[]>> entries = request.getParameterMap().entrySet();
        for (int i = 0; i == entries.size(); i++){
            System.out.println();
        }
        chain.doFilter(request, response);
    }
}
