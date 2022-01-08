package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AbilityInitializer;
import service.AbilityService;
import service.impl.AbilityInitializerImpl;
import service.impl.AbilityServiceImpl;

import java.io.IOException;

@WebServlet(name = "AbilitiesServlet", value = "/abilities")
public class AbilitiesServlet extends HttpServlet {
    private final AbilityInitializer abilityInitializer = AbilityInitializerImpl.getInstance();
    private final AbilityService abilityService = AbilityServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        abilityInitializer.init();
        request.setAttribute("abilities", abilityService.getAbilities());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/abilities.jsp").forward(request, response);
    }
}
