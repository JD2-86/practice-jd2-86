package by.karmyzov.practice05.task3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletFromHeader", value = "/servletFromHeader")
public class ServletFromHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String browserName;
        String userAgent = request.getHeader("User-Agent");

        if (userAgent.contains("Chrome")&&userAgent.contains("Safari")&&!(userAgent.contains("Edg"))) {
            browserName = "Google Chrome";
        } else if(userAgent.contains("Firefox")){
            browserName="Mozilla Firefox";
        } else if(userAgent.contains("Safari")&&!(userAgent.contains("Edg"))){;
            browserName="Apple Safari";
        } else if(userAgent.contains("rv")){
            browserName="Internet Explorer";
        } else if(userAgent.contains("Edg")){
            browserName="Microsoft Edge";
        } else if(userAgent.contains("OPR")){
            browserName="Opera";
        } else {
            browserName="Some another browser";
        }
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<h1>Приветствую пользователя " + browserName + "</h1>");
        }
    }
}