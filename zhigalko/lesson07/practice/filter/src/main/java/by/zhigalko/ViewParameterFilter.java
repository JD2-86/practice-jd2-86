package by.zhigalko;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebFilter(urlPatterns = "*")
public class ViewParameterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key, value) -> System.out.printf("%s : %s\n", key, Arrays.toString(value)));
        chain.doFilter(request, response);
    }
}
