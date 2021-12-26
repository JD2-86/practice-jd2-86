package by.zhigalko.servlets;

import by.zhigalko.access_to_DB.AccessToAbilityStorage;
import by.zhigalko.storage.AbilityStorage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ViewAbilityServlet", value = "/abilities")
public class ViewAbilityServlet extends HttpServlet implements AccessToAbilityStorage {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbilityStorage ability_db = getAccessToAbilityStorage();
        request.setAttribute("ability_storage", ability_db);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/ability.jsp").forward(request,response);
    }
}
