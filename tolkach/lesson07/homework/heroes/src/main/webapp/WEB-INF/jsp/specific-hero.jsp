<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/css-connect.jsp"/>
    <title>Heroes</title>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp"/>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <% response.getWriter().println("Псевдоним: " + request.getAttribute("log") + "<br>"); %>
                    <% response.getWriter().println("Реальное имя: " + request.getAttribute("name") + "<br>"); %>
                    <% response.getWriter().println("Пол: " + request.getAttribute("male") + "<br>"); %>
                    <% response.getWriter().println("Возраст: " + request.getAttribute("age") + "<br>"); %>
                    <% response.getWriter().println("Способность: " + request.getAttribute("abil") + "<br>"); %>
                </div>
            </div>
        </div>
    </section>
</body>
</html>