<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Integer i = (Integer) request.getAttribute("CountOfHeroes"); %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/css-connect.jsp"/>
    <title>Heroes</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <br>
                    <%for (int j = 0; j < i; j++) {
                        response.getWriter().println("<a href=\"/heroes/specific-hero\\" + j + "\">" + request.getAttribute("log" + j) + "</a><br>");

                    }%>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
