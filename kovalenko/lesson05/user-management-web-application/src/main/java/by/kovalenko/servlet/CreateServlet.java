package by.kovalenko.servlet;

import by.kovalenko.exception.UserNotFoundException;
import by.kovalenko.model.User;
import by.kovalenko.service.UserService;
import by.kovalenko.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet(urlPatterns = "/view/command/create-user")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formCreateUser.jsp");
        requestDispatcher.forward(request,response);
    }
}
